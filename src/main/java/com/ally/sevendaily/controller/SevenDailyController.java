package com.ally.sevendaily.controller;

import java.util.HashMap;
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
import com.ally.sevendaily.bean.SevenDaily;
import com.ally.sevendaily.service.SevenDailyService;
import com.ally.sevendailyplan.bean.SevenDailyPlan;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenDaily")
public class SevenDailyController {

	@Autowired
	private SevenDailyService sevenDailyService;

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenDaily/index";
	}
	
	/*
	 * 动向列表
	 * */
	@RequestMapping("/trend")
	public String trend() {
		return "view/sevenDaily/trend";
	}

	
	/*
	 * 跳转到日报添加页
	 */
	@RequestMapping("/toDayAdd")
	public String toAdd() {
		return "view/sevenDaily/sevenDaily-dayAdd";
	}
	
	/*
	 * 跳转到日查看页
	 */
	@RequestMapping("/toDaySelect")
	public String toDaySelect() {
		return "view/sevenDaily/day-select";
	}
	
	/*
	 * 跳转到个人列表页
	 */
	@RequestMapping("/selfIndex")
	public String selfIndex() {
		return "view/sevenDaily/self-index";
	}
	
	/*
	 * 跳转到个人日列表页
	 */
	@RequestMapping("/selfDay")
	public String selfDay() {
		return "view/sevenDaily/self-day";
	}
	
	/*
	 * 跳转到日列表页
	 */
	@RequestMapping("/AllDay")
	public String AllDay() {
		return "view/sevenDaily/all-day";
	}
	
	/*
	 * 跳转到个人日查看页
	 */
	@RequestMapping("/toDaySelfSelect")
	public String toDaySelfSelect() {
		return "view/sevenDaily/day-selectself";
	}
	
	/*
	 * 添加员工工作报告
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加员工工作报告")
	@RequestMapping(value = "/addSevenDaily", method = RequestMethod.POST)
	public Map<String, Object> addSvenDaily(SevenDaily sevenDaily, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenDaily.setdSid(sevenAccount.getaSid());
		if (StringUtils.isEmpty(sevenDaily.getdDate())) {
			map.put("status", 3);
			map.put("msg", "日期不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenDaily.getdWork())) {
			map.put("status", 3);
			map.put("msg", "报告不能为空");
			return map;
		}
		if (sevenDaily.getdType()==null) {
			map.put("status", 3);
			map.put("msg", "类型不能为空");
			return map;
		}
		Boolean result = sevenDailyService.addSvenDaily(sevenDaily);
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
	
	 /* 查看员工日常工作计划
		 */
		@ResponseBody
		@RequestMapping(value = "/getSelectDay", method = RequestMethod.GET)
		public Map<String, Object> selectSevenDailyById(Integer id) {
			Map<String, Object> map = new HashMap<>();
			SevenDaily sevenDaily = sevenDailyService.selectSevenDailyById(id);
			map.put("data", sevenDaily);
			return map;
		}

	/*
	 * 分页查询员工工作报告
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllDayList", method = RequestMethod.GET)
	public Map<String, Object> getAllDayList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer dSid, String dDate) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenDaily> list = sevenDailyService.getDayDailyList(page, limit, dSid, dDate);
		map.put("code", 0);
		map.put("message", "成功");
		map.put("data", list.getList());
		map.put("count", list.getTotal());
		return map;
	}
	
	/*
	 * 分页查询自己工作报告
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfDayList", method = RequestMethod.GET)
	public Map<String, Object> getSelfDayList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String dDate, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenDaily> list = sevenDailyService.getDayDailyList(page, limit, sevenAccount.getaSid(),dDate);
		if (list==null) {
			map.put("data", null);
			map.put("count", null);
		}else {
			map.put("data", list.getList());
			map.put("count", list.getTotal());
		}
		map.put("code", 0);
		map.put("message", "成功");
		return map;
	}
	
	/*
	 * 分页查询员工动向
	 */
	@ResponseBody
	@RequestMapping(value = "/getTrendList", method = RequestMethod.GET)
	public Map<String, Object> getTrendList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer oSid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenDaily> list = sevenDailyService.getTrendList(page, limit, oSid);
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
