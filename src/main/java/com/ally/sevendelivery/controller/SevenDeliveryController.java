package com.ally.sevendelivery.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ally.sevendelivery.bean.SevenDelivery;
import com.ally.sevendelivery.service.SevenDeliveryService;
import com.ally.util.ArchivesLog;
import com.ally.util.ViewInfo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenDelivery")
public class SevenDeliveryController {

	@Autowired
	private SevenDeliveryService sevenDeliveryService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenDelivery/sevenDelivery-add";
	}


	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenDelivery/index";
	}

	/*
	 * 跳转到部门审批列表
	 */
	@RequestMapping("/branchIndex")
	public String branchIndex() {
		return "view/sevenDelivery/branch-index";
	}

	/*
	 * 跳转到部门审批
	 */
	@RequestMapping("/branchKnow")
	public String branchKnow() {
		return "view/sevenDelivery/branch-know";
	}

	/*
	 * 跳转到主管审批列表
	 */
	@RequestMapping("/directorIndex")
	public String directorIndex() {
		return "view/sevenDelivery/director-index";
	}

	/*
	 * 跳转到主管审批
	 */
	@RequestMapping("/directorKnow")
	public String directorKnow() {
		return "view/sevenDelivery/director-know";
	}

	/*
	 * 跳转到经理审批列表
	 */
	@RequestMapping("/mangerIndex")
	public String mangerIndex() {
		return "view/sevenDelivery/manger-index";
	}

	/*
	 * 跳转到经理审批
	 */
	@RequestMapping("/mangerKnow")
	public String mangerKnow() {
		return "view/sevenDelivery/manger-know";
	}

	/*
	 * 添加发货申请
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加发货申请")
	@RequestMapping(value = "/addSevenDelivery", method = RequestMethod.POST)
	public Map<String, Object> addSevenDelivery(SevenDelivery sevenDelivery, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenDelivery.setdSid(sevenAccount.getaSid());
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenDelivery.setApplicationDate(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sevenDelivery.setApplicationState(0);
		if (StringUtils.isEmpty(sevenDelivery.getProjectNum())) {
			map.put("status", 3);
			map.put("msg", "项目编号不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenDelivery.getProjectName())) {
			map.put("status", 3);
			map.put("msg", "项目名称不能为空");
			return map;
		}
		if (sevenDelivery.getDeliveryDate() == null) {
			map.put("status", 3);
			map.put("msg", "发货时间不能为空");
			return map;
		}
		if (sevenDelivery.getMoneyState() == null) {
			map.put("status", 3);
			map.put("msg", "是否来款不能为空");
			return map;
		}
		Boolean result = sevenDeliveryService.addSevenDelivery(sevenDelivery);
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
	 * 部门审批
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "部门审批发货申请")
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public Map<String, Object> addBranch(SevenDelivery sevenDelivery) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenDelivery.setdBranchTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenDeliveryService.addBranch(sevenDelivery);
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
	 * 主管审批
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "主管审批发货申请")
	@RequestMapping(value = "/addDirector", method = RequestMethod.POST)
	public Map<String, Object> addDirector(SevenDelivery sevenDelivery) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenDelivery.setdDirectorTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenDeliveryService.addDirector(sevenDelivery);
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
	 * 经理审批
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "经理审批发货申请")
	@RequestMapping(value = "/addManger", method = RequestMethod.POST)
	public Map<String, Object> addManger(SevenDelivery sevenDelivery) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenDelivery.setdManagerTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenDeliveryService.addManger(sevenDelivery);
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
	 * 查看发货申请
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenDelivery", method = RequestMethod.GET)
	public Map<String, Object> selectSevenDelivery(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenDelivery sevenDelivery = sevenDeliveryService.selectSevenDelivery(id);
		List<ViewInfo> list = new ArrayList<ViewInfo>();
		if (sevenDelivery.getApplicationDate() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenDelivery.getApplicationDate());
			viewInfo.setContent("提交申请");
			list.add(viewInfo);
		}
		if (sevenDelivery.getdBranchTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenDelivery.getdBranchTime());
			viewInfo.setContent(sevenDelivery.getdBranch());
			list.add(viewInfo);
		}
		if (sevenDelivery.getdDirectorTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenDelivery.getdDirectorTime());
			viewInfo.setContent(sevenDelivery.getdDirector());
			list.add(viewInfo);
		}
		if (sevenDelivery.getdManagerTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenDelivery.getdManagerTime());
			viewInfo.setContent(sevenDelivery.getdManager());
			list.add(viewInfo);
		}
		map.put("status", 0);
		map.put("data", list);
		return map;
	}

	/*
	 * 分页发货申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenDeliveryList", method = RequestMethod.GET)
	public Map<String, Object> getSevenDeliveryList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer dSid, Integer applicationState, String projectNum, String projectName,
			String applicationDate) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenDelivery> list = sevenDeliveryService.getSevenDeliveryList(page, limit, dSid, applicationState,
				projectNum, projectName, applicationDate);
		if (list == null) {
			map.put("data", null);
			map.put("total", null);
		} else {
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}

	/*
	 * 分页自己发货申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfDeliveryList", method = RequestMethod.GET)
	public Map<String, Object> getSelfDeliveryList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer applicationState, String projectNum, String projectName, String applicationDate,
			HttpSession session) {
		Map<String, Object> map = new HashMap<>();
			SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
			PageInfo<SevenDelivery> list = sevenDeliveryService.getSevenDeliveryList(page, limit, sevenAccount.getaSid(),
					applicationState, projectNum, projectName, applicationDate);
		
		if (list == null) {
			map.put("data", null);
			map.put("total", null);
		} else {
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
