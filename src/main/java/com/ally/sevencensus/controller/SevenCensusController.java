package com.ally.sevencensus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevencensus.bean.SevenCensus;
import com.ally.sevencensus.service.SevenCensusService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenCensus")
public class SevenCensusController {

	@Autowired
	private SevenCensusService sevenCensusService;
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenCensus/sevenCensus-add";
	}
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenCensus/index";
	}
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/allIndex")
	public String allIndex() {
		return "view/sevenCensus/allIndex";
	}
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/indexSj")
	public String indexSj() {
		return "view/sevenCensus/sj";
	}
	
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/indexXq")
	public String indexXq() {
		return "view/sevenCensus/xq";
	}
	
	/*
	 * 添加数据统计
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加数据统计")
	@RequestMapping(value = "/addSevenCensus", method = RequestMethod.POST)
	public Map<String, Object> addSevenCensus(SevenCensus sevenCensus, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenCensus.setStaffId(sevenAccount.getaSid());
		if (sevenCensus.getProductId() == null) {
			map.put("status", 3);
			map.put("msg", "所属产品不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenCensus.getSaleNumber())) {
			map.put("status", 3);
			map.put("msg", "销售数量不能为空");
			return map;
		}
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenCensus.setCensusDate(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenCensusService.addSevenCensus(sevenCensus);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
			return map;
		} else {
			map.put("status", 3);
			map.put("msg", "添加失败");
			return map;
		}
	}
	

	/*
	 * 分页数据统计
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenCensusList", method = RequestMethod.GET)
	public Map<String, Object> getSevenCensusList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer productId,String censusDate) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenCensus> list = sevenCensusService.getSevenCensusList(page, limit, productId, censusDate);
		map.put("code", 0);
		map.put("message", "成功");
		map.put("data", list.getList());
		map.put("total", list.getTotal());
		return map;
	}
	
	
	/*
	 * 当月产品销售额
	 */
	@ResponseBody
	@RequestMapping(value = "/getCensusNumber", method = RequestMethod.GET)
	public Map<String, Object> getCensusNumber() {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM");
		String censusDate = dFormat.format(System.currentTimeMillis());
		List<SevenCensus> list = sevenCensusService.getCensusNumber(censusDate);
		if (list!=null) {
			map.put("status", 0);
			map.put("msg", "成功");
			map.put("data", list);
		} else {
			map.put("status", 0);
			map.put("msg", "成功");
		}
		return  map;
	}
	
	/*
	 * 当月个人回款
	 */
	@ResponseBody
	@RequestMapping(value = "/getCensusMoney", method = RequestMethod.GET)
	public Map<String, Object> getCensusMoney() {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM");
		String censusDate = dFormat.format(System.currentTimeMillis());
		List<SevenCensus> list =sevenCensusService.getCensusMoney(censusDate);
		if (list!=null) {
			map.put("status", 0);
			map.put("msg", "成功");
			map.put("data", list);
		} else {
			map.put("status", 0);
			map.put("msg", "成功");
		}
		return  map;
	}
}
