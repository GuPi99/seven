package com.ally.sevenprojectfundplan.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenprojectfundplan.bean.SevenProjectFundPlan;
import com.ally.sevenprojectfundplan.service.SevenProjectFundPlanService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenProjectFundPlan")
public class SevenProjectFundPlanController {

	@Autowired
	private SevenProjectFundPlanService sevenProjectFundPlanService;
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenProjectFundPlan/sevenProjectFundPlan-add";
	}
	
	/*
	 * 跳转到首页页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProjectFundPlan/index";
	}
	
	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenProjectFundPlan/sevenProjectFundPlan-update";
	}
	
	/*
	 * 添加项目资金计划
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加项目资金计划")
	@RequestMapping(value = "/addSevenProjectFundPlan", method = RequestMethod.POST)
	public Map<String, Object> addSevenProjectFundPlan(SevenProjectFundPlan sevenProjectFundPlan) {
		Map<String, Object> map = new HashMap<>();
		if (sevenProjectFundPlan.getPfpPlanDate()==null) {
			map.put("status", 3);
			map.put("msg", "计划回收日期不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenProjectFundPlan.getPfpPlanSum())) {
			map.put("status", 3);
			map.put("msg", "计划回收金额不能为空");
			return map;
		}
		Boolean result = sevenProjectFundPlanService.addSevenProjectFundPlan(sevenProjectFundPlan);
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
	 * 查看资金回收计划
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenProjectFundPlan", method = RequestMethod.GET)
	public Map<String, Object> selectSevenProjectFundPlan(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenProjectFundPlan sevenProjectFundPlan = sevenProjectFundPlanService.selectSevenProjectFundPlan(id);
		map.put("status", 0);
		map.put("data", sevenProjectFundPlan);
		return map;
	}
	
	/*
	 * 修改项目资金计划
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改项目资金计划")
	@RequestMapping(value = "/updateSevenProjectFundPlan", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenProjectFundPlan(SevenProjectFundPlan sevenProjectFundPlan) {
		Map<String, Object> map = new HashMap<>();
		if (sevenProjectFundPlan.getPfpActualDate()==null) {
			map.put("status", 3);
			map.put("msg", "实际回收日期不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenProjectFundPlan.getPfpActualSum())) {
			map.put("status", 3);
			map.put("msg", "实际回收金额不能为空");
			return map;
		}
		Boolean result = sevenProjectFundPlanService.updateSevenProjectFundPlan(sevenProjectFundPlan);
		if (result) {
			map.put("status", 0);
			map.put("msg", "修改成功");
			return map;
		} else {
			map.put("status", 3);
			map.put("msg", "修改失败");
			return map;
		}
	}
	
	/*
	 * 分页查询项目产品信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenProjectFundPlanList", method = RequestMethod.GET)
	public Map<String, Object> getSevenProjectFundPlanList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer  pfpPid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenProjectFundPlan> list = null;
		if (pfpPid==null) {
			list=null;
			map.put("data", null);
			map.put("total", null);
		}else {
			list=sevenProjectFundPlanService.getSevenProjectFundPlanList(page, limit, pfpPid);
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}

}
