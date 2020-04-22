package com.ally.sevendailyplan.controller;

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
import com.ally.sevendailyplan.bean.SevenDailyPlan;
import com.ally.sevendailyplan.service.SevenDailyPlanService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenDailyPlan")
public class SevenDailyPlanController {

	@Autowired
	private SevenDailyPlanService sevenDailyPlanService;

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenDailyPlan/index";
	}
	
	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/selfIndex")
	public String selfIndex() {
		return "view/sevenDailyPlan/self-index";
	}
	
	/*
	 * 跳转到日列表页
	 */
	@RequestMapping("/selfDay")
	public String selfDay() {
		return "view/sevenDailyPlan/self-day";
	}
	
	
	/*
	 * 跳转到日添加页
	 */
	@RequestMapping("/toDayAdd")
	public String toDayAdd() {
		return "view/sevenDailyPlan/sevenDailyPlan-dayAdd";
	}
	
	/*
	 * 跳转到日查看页
	 */
	@RequestMapping("/toDaySelect")
	public String toDaySelect() {
		return "view/sevenDailyPlan/day-select";
	}
	
	/*
	 * 跳转到周列表页
	 */
	@RequestMapping("/selfWeek")
	public String selfWeek() {
		return "view/sevenDailyPlan/self-week";
	}
	
	/*
	 * 跳转到周添加页
	 */
	@RequestMapping("/toWeekAdd")
	public String toWeekAdd() {
		return "view/sevenDailyPlan/sevenDailyPlan-weekAdd";
	}
	
	/*
	 * 跳转到周添加页
	 */
	@RequestMapping("/addweek")
	public String addweek() {
		return "view/sevenDailyPlan/addweek";
	}
	
	/*
	 * 跳转到月列表页
	 */
	@RequestMapping("/selfMonth")
	public String selfMonth() {
		return "view/sevenDailyPlan/self-month";
	}

	/*
	 * 添加员工日常工作计划
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加员工日常工作计划")
	@RequestMapping(value = "/addSevenDailyPlan", method = RequestMethod.POST)
	public Map<String, Object> addSevenDailyPlan(SevenDailyPlan sevenDailyPlan, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenDailyPlan.setDpSid(sevenAccount.getaSid());
		if (StringUtils.isEmpty(sevenDailyPlan.getDpDate())) {
			map.put("status", 3);
			map.put("msg", "日期不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenDailyPlan.getDpWork())) {
			map.put("status", 3);
			map.put("msg", "报告不能为空");
			return map;
		}
		if (sevenDailyPlan.getDpType()==null) {
			map.put("status", 3);
			map.put("msg", "类型不能为空");
			return map;
		}
		Boolean result = sevenDailyPlanService.addSevenDailyPlan(sevenDailyPlan);
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
	public Map<String, Object> selectSevenDailyPlanById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenDailyPlan sevenDailyPlan = sevenDailyPlanService.selectSevenDailyPlanById(id);
		map.put("data", sevenDailyPlan);
		return map;
	}

	/*
	 * 分页查询员工日常工作计划
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenDailyPlanList", method = RequestMethod.GET)
	public Map<String, Object> getSevenDailyPlanList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer dpSid, Integer dpType, String dpDate) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenDailyPlan> list = sevenDailyPlanService.getSevenDailyPlanList(page, limit, dpSid, dpType, dpDate);
		if (list==null) {
			map.put("data", null);
			map.put("count", null);
		}else {
			map.put("data", list.getList());
			map.put("count", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}

	/*
	 * 分页查询自己日常工作计划
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfDayList", method = RequestMethod.GET)
	public Map<String, Object> getSelfDayList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit,  Integer dpWhere, String dpDate, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenDailyPlan> list = sevenDailyPlanService.getSelfDayList(page, limit, sevenAccount.getaSid(),
				dpWhere, dpDate);
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
	 * 分页查询自己周工作计划
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfWeekList", method = RequestMethod.GET)
	public Map<String, Object> getSelfWeekList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit,  Integer dpWhere, String dpDate, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenDailyPlan> list = sevenDailyPlanService.getSelfWeekList(page, limit, sevenAccount.getaSid(),
				dpWhere, dpDate);
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
}
