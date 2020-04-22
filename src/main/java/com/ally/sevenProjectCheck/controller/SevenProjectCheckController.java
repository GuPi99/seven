package com.ally.sevenProjectCheck.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenProjectCheck.bean.SevenProjectCheck;
import com.ally.sevenProjectCheck.service.SevenProjectCheckService;
import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenProjectCheck")
public class SevenProjectCheckController {

	@Autowired
	private SevenProjectCheckService sevenProjectCheckService;
	
	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProjectCheck/index";
	}
	
	/*
	 * 部门审批
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "项目审批")
	@RequestMapping(value = "/addProjectCheck", method = RequestMethod.POST)
	public Map<String, Object> addProjectCheck(SevenProjectCheck sevenProjectCheck,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenProjectCheck.setPcSid(sevenAccount.getaSid());
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenProjectCheck.setPcTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sevenProjectCheck.setPcOther(0);
		Boolean flag =sevenProjectCheckService.updateOther(sevenProjectCheck.getPcPid());
		Boolean result = sevenProjectCheckService.addProjectCheck(sevenProjectCheck);
		if (result) {
			map.put("status", 0);
			map.put("msg", "审批成功");
		} else {
			map.put("status", 3);
			map.put("msg", "审批失败");
		}
		return map;
	}
	
	
	
	/*
	 * 查询项目审批信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenProjectCheckList", method = RequestMethod.GET)
	public Map<String, Object> getSevenProjectCheckList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer pcPid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenProjectCheck> list = null;
		if (pcPid == null) {
			list = null;
			map.put("data", null);
			map.put("total", null);
		} else {
			list = sevenProjectCheckService.getSevenProjectCheckList(page, limit, pcPid);
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
