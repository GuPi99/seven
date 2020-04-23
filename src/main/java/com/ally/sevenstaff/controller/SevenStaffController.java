package com.ally.sevenstaff.controller;

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
import com.ally.sevenmessage.bean.SevenMessage;
import com.ally.sevenmessage.service.SevenMessageService;
import com.ally.sevenoffice.bean.SevenOffice;
import com.ally.sevenoffice.service.SevenOfficeService;
import com.ally.sevenprint.bean.SevenPrint;
import com.ally.sevenprint.service.SevenPrintService;
import com.ally.sevenstaff.bean.SevenStaff;
import com.ally.sevenstaff.bean.StaffMsg;
import com.ally.sevenstaff.service.SevenStaffService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenStaff")
public class SevenStaffController {

	@Autowired
	private SevenStaffService sevenStaffService;
	@Autowired
	private SevenMessageService sevenMessageService;
	@Autowired
	private SevenOfficeService sevenOfficeService;
	@Autowired
	private SevenPrintService sevenPrintService;
	
	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenStaff/index";
	}
	
	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/msg")
	public String msg() {
		return "view/index/msg";
	}
	
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenStaff/sevenStaff-add";
	}
	
	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenStaff/sevenStaff-update";
	}


	/*
	 * 添加员工信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加员工信息")
	@RequestMapping(value = "/addSevenStaff", method = RequestMethod.POST)
	public Map<String, Object> addSevenStaff(SevenStaff sevenStaff) {
		Map<String, Object> map = new HashMap<>();
		sevenStaff.setsState(1);
		if (StringUtils.isEmpty(sevenStaff.getsName())) {
			map.put("status", 3);
			map.put("msg", "员工姓名不能为空");
			return map;
		}
		if (sevenStaff.getsSex()==null) {
			map.put("status", 3);
			map.put("msg", "员工性别不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenStaff.getsDateBirth())) {
			map.put("status", 3);
			map.put("msg", "员工出生年月不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenStaff.getsPhone())) {
			map.put("status", 3);
			map.put("msg", "员工电话不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenStaff.getsEmail())) {
			map.put("status", 3);
			map.put("msg", "员工邮箱不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenStaff.getsAddress())) {
			map.put("status", 3);
			map.put("msg", "员工住址不能为空");
			return map;
		}
		Boolean result = sevenStaffService.addSevenStaff(sevenStaff);
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
	 * 修改员工信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改员工信息")
	@RequestMapping(value = "/updateSevenStaff", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenStaff(SevenStaff sevenStaff) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenStaff.getsName())) {
			map.put("status", 3);
			map.put("msg", "员工姓名不能为空");
			return map;
		}
		if (sevenStaff.getsSex()==null) {
			map.put("status", 3);
			map.put("msg", "员工性别不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenStaff.getsDateBirth())) {
			map.put("status", 3);
			map.put("msg", "员工出生年月不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenStaff.getsPhone())) {
			map.put("status", 3);
			map.put("msg", "员工电话不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenStaff.getsEmail())) {
			map.put("status", 3);
			map.put("msg", "员工邮箱不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenStaff.getsAddress())) {
			map.put("status", 3);
			map.put("msg", "员工住址不能为空");
			return map;
		}
		Boolean result = sevenStaffService.updateSevenStaff(sevenStaff);
		if (result) {
			map.put("status", 0);
			map.put("msg", "修改成功");
			return map;
		} else {
			map.put("status", 1);
			map.put("msg", "修改失败");
			return map;
		}
	}
	
	/*
	 * 修改员工状态信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改员工状态信息")
	@RequestMapping(value = "/updateSevenStaffState", method = RequestMethod.GET)
	public Map<String, Object> updateSevenStaffState(Integer id, Integer sState) {
		Map<String, Object> map = new HashMap<>();
		System.out.println(sState);
		Boolean result = sevenStaffService.updateSevenStaffState(id,sState);
		if (result) {
			map.put("status", 0);
			map.put("msg", "修改成功");
		} else {
			map.put("status", 1);
			map.put("msg", "修改失败");
		}
		return map;
	}
	
	/*
	 * 全部查询
	 * */
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public Map<String, Object> selectAll() {
		Map<String, Object> map = new HashMap<>();
		List<SevenStaff> list = sevenStaffService.selectAll();
		map.put("status", 0);
		map.put("data", list);
		return map;
	}
	
	

	/*
	 * 查看员工信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenStaffById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenStaffById(Integer id,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenStaff sevenStaff=null;
		if (id!=null) {
			 sevenStaff = sevenStaffService.selectSevenStaffById(id);
		} else {
			SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
			sevenStaff= sevenStaffService.selectSevenStaffById(sevenAccount.getaSid());
		}
		map.put("status", 0);
		map.put("data", sevenStaff);
		return map;
	}

	/*
	 * 分页查询员工信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenStaffList", method = RequestMethod.GET)
	public Map<String, Object> getSevenStaffList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer sSex,String sName,String sDateBirth) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenStaff> list = sevenStaffService.getSevenStaffList(page, limit, sSex,sName,sDateBirth);
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
	 * 个人信息展示
	 */
	@ResponseBody
	@RequestMapping(value = "/selectPersonal", method = RequestMethod.GET)
	public Map<String, Object> selectPersonal(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenStaff sevenStaff=null;
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenStaff= sevenStaffService.selectSevenStaffById(sevenAccount.getaSid());
		SevenOffice sevenOffice=sevenOfficeService.selectBefore(sevenStaff.getId());
		SevenMessage sevenMessage = sevenMessageService.selectSevenMessageById(sevenOffice.getoPost());
		SevenPrint sevenPrint = sevenPrintService.selectSevenPrint(sevenAccount.getaPid());
		StaffMsg sMsg =new StaffMsg();
		sMsg.setSevenMessage(sevenMessage);
		sMsg.setSevenStaff(sevenStaff);
		sMsg.setiUrl(sevenPrint.getpUrl());
		map.put("status", 0);
		map.put("data", sMsg);
		return map;
	}
	
}
