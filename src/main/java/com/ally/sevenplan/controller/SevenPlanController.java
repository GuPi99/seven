package com.ally.sevenplan.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenplan.bean.SevenPlan;
import com.ally.sevenplan.service.SevenPlanService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenPlan")
public class SevenPlanController {

	@Autowired
	private SevenPlanService sevenPlanService;

	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenPlan/index";
	}

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenPlan/sevenPlan-add";
	}

	/*
	 * 添加出差申请的行程安排
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加出差申请的行程安排")
	@RequestMapping(value = "/addSevenPlan", method = RequestMethod.POST)
	public Map<String, Object> addSevenPlan(SevenPlan sevenPlan) {
		Map<String, Object> map = new HashMap<>();
		if (sevenPlan.getpDate()==null) {
			map.put("status", 1);
			map.put("msg", "日期不能为空");
			return map;
		}
		if (sevenPlan.getpIs()==null) {
			map.put("status", 1);
			map.put("msg", "请选择上午或者下午");
			return map;
		}
		if (StringUtils.isEmpty(sevenPlan.getpVehicle())) {
			map.put("status", 1);
			map.put("msg", "交通工具不能为空");
			return map;
		}
		if (sevenPlan.getpFid()==null) {
			map.put("status", 1);
			map.put("msg", "拜访客户不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenPlan.getpGoal())) {
			map.put("status", 1);
			map.put("msg", "交通工具不能为空");
			return map;
		}
		Boolean result = sevenPlanService.addSevenPlan(sevenPlan);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
			return map;
		} else {
			map.put("status", 1);
			map.put("msg", "添加失败");
			return map;
		}
	}

	/*
	 * 删除出差申请的行程安排
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除出差申请的行程安排")
	@RequestMapping(value = "/deleteSevenPlan", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenPlan(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenPlanService.deleteSevenPlan(id);
		if (result) {
			map.put("status", 0);
			map.put("msg", "删除成功");
		} else {
			map.put("status", 1);
			map.put("msg", "删除失败");
		}
		return map;
	}

	/*
	 * 分页行程安排
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenPlanList", method = RequestMethod.GET)
	public Map<String, Object> getSevenPlanList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer pEid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenPlan> list = null;
		if (pEid == null) {
			list = null;
			map.put("data", null);
			map.put("total", null);
		} else {
			list = sevenPlanService.getSevenPlanList(page, limit, pEid);
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
