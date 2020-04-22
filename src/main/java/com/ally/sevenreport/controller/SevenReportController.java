package com.ally.sevenreport.controller;

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
import com.ally.sevenreport.bean.SevenReport;
import com.ally.sevenreport.service.SevenReportService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenReport")
public class SevenReportController {

	@Autowired
	private SevenReportService sevenReportService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenReport/sevenReport-add";
	}

	/*
	 * 跳转到指示列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenReport/index";
	}

	/*
	 * 跳转到回复列表页
	 */
	@RequestMapping("/replyIndex")
	public String replyIndex() {
		return "view/sevenReport/reply-index";
	}

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/selfIndex")
	public String selfIndex() {
		return "view/sevenReport/self-index";
	}

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/toSelect")
	public String toSelect() {
		return "view/sevenReport/sevenReport-select";
	}

	/*
	 * 添加客户拜访报告
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加客户拜访报告")
	@RequestMapping(value = "/addSevenReport", method = RequestMethod.POST)
	public Map<String, Object> addSevenReport(SevenReport sevenReport, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenReport.setrSid(sevenAccount.getaSid());
		if (sevenReport.getrDate() == null) {
			map.put("status", 3);
			map.put("msg", "日期不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrCrew())) {
			map.put("status", 3);
			map.put("msg", "同行人员不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrTitle())) {
			map.put("status", 3);
			map.put("msg", "项目名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrFirm())) {
			map.put("status", 3);
			map.put("msg", "拜访公司不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrUser())) {
			map.put("status", 3);
			map.put("msg", "最终用户不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrGoal())) {
			map.put("status", 3);
			map.put("msg", "目的/背景不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrVerdict())) {
			map.put("status", 3);
			map.put("msg", "结论/结果不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrRecord())) {
			map.put("status", 3);
			map.put("msg", "访谈记录不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrActivity())) {
			map.put("status", 3);
			map.put("msg", "下次活动不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenReport.getrAssist())) {
			map.put("status", 3);
			map.put("msg", "需协助事项不能为空");
			return map;
		}
		System.out.println(sevenReport);
		Boolean result = sevenReportService.addSevenReport(sevenReport);
		System.out.println(result);
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
	 * 添加客户拜访报告指示
	 * */
	@ResponseBody
	@ArchivesLog(operteContent = "添加客户拜访报告指示")
	@RequestMapping(value="/addIndicate",method=RequestMethod.POST)
	public Map<String, Object> addIndicate(SevenReport sevenReport) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenReportService.addIndicate(sevenReport);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
		} else {
			map.put("status", 3);
			map.put("msg", "添加失败");
		}
		return map;
	}
	
	/*
	 * 添加客户拜访报告回复
	 * */
	@ResponseBody
	@ArchivesLog(operteContent = "添加客户拜访报告回复")
	@RequestMapping(value="/addReply",method=RequestMethod.POST)
	public Map<String, Object> addReply(SevenReport sevenReport) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenReportService.addReply(sevenReport);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
		} else {
			map.put("status", 3);
			map.put("msg", "添加失败");
		}
		return map;
	}
	
	/*
	 * 查看
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenReport", method = RequestMethod.GET)
	public Map<String, Object> selectSevenReport(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenReport sevenReport = sevenReportService.selectSevenReport(id);
		map.put("status", 0);
		map.put("data", sevenReport);
		return map;
	}


	/*
	 * 分页查询客户拜访报告
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenReportList", method = RequestMethod.GET)
	public Map<String, Object> getSevenReportList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer rSid, String rDate, String rTitle) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenReport> list = sevenReportService.getSevenReportList(page, limit, rSid, rDate, rTitle);
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
	 * 分页查询自己客户拜访报告
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfReportList", method = RequestMethod.GET)
	public Map<String, Object> getSelfReportList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String rDate, String rTitle, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenReport> list = sevenReportService.getSevenReportList(page, limit, sevenAccount.getaSid(), rDate,
				rTitle);
		if (list==null) {
			map.put("data", null);
			map.put("total", null);
		}else {
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("code", 0);
		map.put("message", "成功");
		return map;
	}
}
