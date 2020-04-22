package com.ally.sevenprojectreport.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenProjectCheck.bean.SevenProjectCheck;
import com.ally.sevenProjectCheck.service.SevenProjectCheckService;
import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenprojectreport.bean.SevenProjectReport;
import com.ally.sevenprojectreport.service.SevenProjectReportService;
import com.ally.util.ArchivesLog;

@Controller
@RequestMapping("/sevenProjectReport")
public class SevenProjectReportController {
	
	@Autowired
	private SevenProjectReportService sevenProjectReportService;
	@Autowired
	private SevenProjectCheckService sevenProjectCheckService;
	
	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProjectReport/index";
	}
	
	/*
	 * 添加项目报告
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加项目报告")
	@RequestMapping(value = "/addSevenProjectReport", method = RequestMethod.POST)
	public Map<String, Object> addSevenProjectReport(SevenProjectReport sevenProjectReport,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenProjectReport.getPrReport())) {
			map.put("status", 1);
			map.put("msg", "报告内容不能为空");
			return map;
		}
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenProjectReport.setPrTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenProjectReportService.addSevenProjectReport(sevenProjectReport);
		if (result) {
			SevenProjectCheck sevenProjectCheck=new SevenProjectCheck();
			SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
			sevenProjectCheck.setPcSid(sevenAccount.getaSid());
			sevenProjectCheck.setPcPid(sevenProjectReport.getPrPid());
			sevenProjectCheck.setPcState(4);
			sevenProjectCheck.setPcOther(0);
			sevenProjectCheck.setPcEvaluation("项目已完结");
			try {
				sevenProjectCheck.setPcTime(dFormat.parse(format));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Boolean flag=sevenProjectCheckService.addProjectCheck(sevenProjectCheck);
			if (flag) {
				map.put("status", 0);
				map.put("msg", "添加成功");
				return map;
			} else {
				map.put("status", 1);
				map.put("msg", "添加失败");
				return map;
			}
		} else {
			map.put("status", 1);
			map.put("msg", "添加失败");
			return map;
		}
	}
	
	/*
	 * 查询项目的报告
	 */
	@ResponseBody
	@RequestMapping(value = "/selectProjectReport", method = RequestMethod.GET)
	public Map<String, Object> selectProjectReport(Integer prPid) {
		Map<String, Object> map = new HashMap<>();
		SevenProjectReport sevenProjectReport = sevenProjectReportService.selectProjectReport(prPid);
		map.put("status", 0);
		map.put("data", sevenProjectReport);
		return map;
	}
}
