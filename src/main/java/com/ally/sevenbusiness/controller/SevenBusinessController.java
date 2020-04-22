package com.ally.sevenbusiness.controller;

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
import com.ally.sevenbusiness.bean.SevenBusiness;
import com.ally.sevenbusiness.service.SevenBusinessService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenBusiness")
public class SevenBusinessController {

	@Autowired
	private SevenBusinessService sevenBusinessService;
	
	/*
	 * 跳转到业务需求添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenBusiness/sevenBusiness-add";
	}
	
	/*
	 * 跳转到业务需求添加页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenBusiness/index";
	}
	
	/*
	 * 添加数据统计
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加业务需求")
	@RequestMapping(value = "/addSevenBusiness", method = RequestMethod.POST)
	public Map<String, Object> addSevenBusiness(SevenBusiness sevenBusiness, HttpSession session) {
		Map<String, Object> map=new HashMap<String, Object>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenBusiness.setDraftId(sevenAccount.getaSid());
		sevenBusiness.setStatus(0);
		if (sevenBusiness.getStaffId()==null) {
			map.put("status", 3);
			map.put("msg", "请选择员工");
			return map;
		}
		if (StringUtils.isEmpty(sevenBusiness.getDispatchNumber())) {
			map.put("status", 3);
			map.put("msg", "发文工号不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenBusiness.getTitle())) {
			map.put("status", 3);
			map.put("msg", "标题不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenBusiness.getText())) {
			map.put("status", 3);
			map.put("msg", "内容不能为空");
			return map;
		}
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenBusiness.setDraftDate(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result=sevenBusinessService.addSevenBusiness(sevenBusiness);
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
	 * 分页需求列表页
	 * */
	@ResponseBody
	@RequestMapping(value = "/getSevenBusinessList", method = RequestMethod.GET)
	public Map<String, Object> getSevenBusinessList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String title,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenBusiness> list = sevenBusinessService.getSevenBusinessList(page, limit, title,sevenAccount.getaSid());
		map.put("code", 0);
		map.put("message", "成功");
		map.put("data", list.getList());
		map.put("total", list.getTotal());
		return map;
	}
	
	
	/*
	 * 首页显示业务需求
	 */
	@ResponseBody
	@RequestMapping(value = "/getIndexList", method = RequestMethod.GET)
	public Map<String, Object> getIndexList(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		List<SevenBusiness> list = sevenBusinessService.getIndexList(sevenAccount.getaSid());
		Integer count=sevenBusinessService.getIndexCount(sevenAccount.getaSid());
		if (list==null) {
			map.put("data", null);
			map.put("total", null);
		}else {
			map.put("data", list);
			map.put("total", count);
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
	
	/*
	 * 更改指派是否已读
	 */
	@ResponseBody
	@RequestMapping(value = "/updateReadStatus", method = RequestMethod.GET)
	public Map<String, Object> updateReadStatus(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenBusinessService.updateReadStatus(id);
		if (result) {
			map.put("status", 0);
			return map;
		} else {
			map.put("status", 1);
			return map;
		}
	}
}
