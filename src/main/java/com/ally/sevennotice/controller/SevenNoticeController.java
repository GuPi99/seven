package com.ally.sevennotice.controller;

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
import com.ally.sevennotice.bean.SevenNotice;
import com.ally.sevennotice.service.SevenNoticeSerivce;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenNotice")
public class SevenNoticeController {

	@Autowired
	private SevenNoticeSerivce sevenNoticeSerivce;
	/*
	 * 跳转到业务需求添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenNotice/sevenNotice-add";
	}
	
	/*
	 * 跳转到业务需求添加页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenNotice/index";
	}
	
	/*
	 * 发布部门公告
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "发布部门公告")
	@RequestMapping(value = "/addSevenNotice", method = RequestMethod.POST)
	public Map<String, Object> addSevenNotice(SevenNotice sevenNotice, HttpSession session) {
		Map<String, Object> map=new HashMap<String, Object>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenNotice.setDraftId(sevenAccount.getaSid());
		if (StringUtils.isEmpty(sevenNotice.getDispatchNumber())) {
			map.put("status", 3);
			map.put("msg", "发文工号不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenNotice.getTitle())) {
			map.put("status", 3);
			map.put("msg", "标题不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenNotice.getText())) {
			map.put("status", 3);
			map.put("msg", "内容不能为空");
			return map;
		}
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenNotice.setDraftDate(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result=sevenNoticeSerivce.addSevenNotice(sevenNotice);
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
	 * 分页部门公告
	 * */
	@ResponseBody
	@RequestMapping(value = "/getSevenNoticeList", method = RequestMethod.GET)
	public Map<String, Object> getSevenNoticeList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String title) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenNotice> list = sevenNoticeSerivce.getSevenNoticeList(page, limit, title);
		map.put("status", 0);
		map.put("message", "成功");
		map.put("data", list.getList());
		map.put("total", list.getTotal());
		return map;
	}
	
	
	/*
	 * 首页显示部门公告
	 */
	@ResponseBody
	@RequestMapping(value = "/getIndexList", method = RequestMethod.GET)
	public Map<String, Object> getIndexList() {
		Map<String, Object> map = new HashMap<>();
		List<SevenNotice> list = sevenNoticeSerivce.getIndexList();
		if (list==null) {
			map.put("data", null);
		}else {
			map.put("data", list);
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
