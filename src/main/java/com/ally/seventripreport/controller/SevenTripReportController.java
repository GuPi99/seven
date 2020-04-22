package com.ally.seventripreport.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.seventripreport.bean.SevenTripReport;
import com.ally.seventripreport.service.SevenTripReportService;
import com.ally.util.ArchivesLog;

@Controller
@RequestMapping("/sevenTripReport")
public class SevenTripReportController {

	@Autowired
	private SevenTripReportService sevenTripReportService;
	
	
	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenTripReport/index";
	}
	
	/*
	 * 添加出差申请的出差报告
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加出差申请的出差报告")
	@RequestMapping(value = "/addSevenTripReport", method = RequestMethod.POST)
	public Map<String, Object> addSevenTripReport(SevenTripReport sevenTripReport) {
		Map<String, Object> map = new HashMap<>();
		if (sevenTripReport.getTrDate()==null) {
			map.put("status", 1);
			map.put("msg", "开始日期不能为空");
			return map;
		}
		if (sevenTripReport.getTrEnd()==null) {
			map.put("status", 1);
			map.put("msg", "返程日期不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTripReport.getTrContent())) {
			map.put("status", 1);
			map.put("msg", "报告内容不能为空");
			return map;
		}
		Boolean result = sevenTripReportService.addSevenTripReport(sevenTripReport);
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
	 * 查询出差申请的出差报告
	 */
	@ResponseBody
	@RequestMapping(value = "/selectTripReport", method = RequestMethod.GET)
	public Map<String, Object> selectTripReport(Integer trEid) {
		Map<String, Object> map = new HashMap<>();
		SevenTripReport sevenTripReport = sevenTripReportService.selectTripReport(trEid);
		if (sevenTripReport==null) {
			map.put("status", 1);
			map.put("msg", "当前出差申请未编写出差报告");
		} else {
			map.put("status", 0);
			map.put("data", sevenTripReport);
		}
		return map;
	}
}
