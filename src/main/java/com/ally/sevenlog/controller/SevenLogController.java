package com.ally.sevenlog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenlog.bean.SevenLog;
import com.ally.sevenlog.service.SevenLogService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenLog")
public class SevenLogController {

	@Autowired
	private SevenLogService sevenLogService;

	/*
	 * 跳转到首页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/home/index";
	}

	/*
	 * 分页查询自己操作日志信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenLogSelfList", method = RequestMethod.GET)
	public Map<String, Object> getSevenLogSelfList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String lDatetime, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenLog> list = sevenLogService.getSevenLogSelfList(page, limit, sevenAccount.getId(), lDatetime);
		if (list==null) {
			map.put("data", null);
			map.put("total", null);
		}else {
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}

	/*
	 * 分页查询日志信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenLogList", method = RequestMethod.GET)
	public Map<String, Object> getSevenLogList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String lDatetime) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenLog> list = sevenLogService.getSevenLogList(page, limit, lDatetime);
		if (list==null) {
			map.put("data", null);
			map.put("total", null);
		}else {
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
