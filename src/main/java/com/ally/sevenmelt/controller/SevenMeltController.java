package com.ally.sevenmelt.controller;

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
import com.ally.sevenmelt.bean.SevenMelt;
import com.ally.sevenmelt.service.SevenMeltService;
import com.ally.util.ArchivesLog;
import com.ally.util.ViewInfo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenMelt")
public class SevenMeltController {

	@Autowired
	private SevenMeltService sevenMeltService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenMelt/sevenMelt-add";
	}

	/*
	 * 跳转到查看页
	 */
	@RequestMapping("/toView")
	public String toView() {
		return "view/sevenMelt/view";
	}

	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenMelt/index";
	}

	/*
	 * 跳转到部门审批列表
	 */
	@RequestMapping("/branchIndex")
	public String branchIndex() {
		return "view/sevenMelt/branch-index";
	}

	/*
	 * 跳转到部门审批
	 */
	@RequestMapping("/branchKnow")
	public String branchKnow() {
		return "view/sevenMelt/branch-know";
	}

	/*
	 * 跳转到主管审批列表
	 */
	@RequestMapping("/directorIndex")
	public String directorIndex() {
		return "view/sevenMelt/director-index";
	}

	/*
	 * 跳转到主管审批
	 */
	@RequestMapping("/directorKnow")
	public String directorKnow() {
		return "view/sevenMelt/director-know";
	}

	/*
	 * 跳转到经理审批列表
	 */
	@RequestMapping("/mangerIndex")
	public String mangerIndex() {
		return "view/sevenMelt/manger-index";
	}

	/*
	 * 跳转到经理审批
	 */
	@RequestMapping("/mangerKnow")
	public String mangerKnow() {
		return "view/sevenMelt/manger-know";
	}

	/*
	 * 添加报销申请
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加报销申请")
	@RequestMapping(value = "/addSevenMelt", method = RequestMethod.POST)
	public Map<String, Object> addSevenMelt(SevenMelt sevenMelt, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenMelt.setmSid(sevenAccount.getaSid());
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenMelt.setmApplyTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sevenMelt.setmState(0);
		if (StringUtils.isEmpty(sevenMelt.getmItems())) {
			map.put("status", 3);
			map.put("msg", "报销项目不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenMelt.getmFigure())) {
			map.put("status", 3);
			map.put("msg", "报销金额不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenMelt.getmDescribe())) {
			map.put("status", 3);
			map.put("msg", "报销描述不能为空");
			return map;
		}
		Boolean result = sevenMeltService.addSevenMelt(sevenMelt);
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
	@ArchivesLog(operteContent = "部门审批报销申请")
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public Map<String, Object> addBranch(SevenMelt sevenMelt) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenMelt.setmBranchTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenMeltService.addBranch(sevenMelt);
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
	@ArchivesLog(operteContent = "主管审批报销申请")
	@RequestMapping(value = "/addDirector", method = RequestMethod.POST)
	public Map<String, Object> addDirector(SevenMelt sevenMelt) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenMelt.setmDirectorTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenMeltService.addDirector(sevenMelt);
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
	@ArchivesLog(operteContent = "主管审批报销申请")
	@RequestMapping(value = "/addManger", method = RequestMethod.POST)
	public Map<String, Object> addManger(SevenMelt sevenMelt) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenMelt.setmManagerTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenMeltService.addManger(sevenMelt);
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
	 * 查看报销申请
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenMelt", method = RequestMethod.GET)
	public Map<String, Object> selectSevenMelt(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenMelt sevenMelt = sevenMeltService.selectSevenMelt(id);
		List<ViewInfo> list = new ArrayList<ViewInfo>();
		if (sevenMelt.getmApplyTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenMelt.getmApplyTime());
			viewInfo.setContent("提交申请");
			list.add(viewInfo);
		}
		if (sevenMelt.getmBranchTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenMelt.getmBranchTime());
			viewInfo.setContent(sevenMelt.getmBranch());
			list.add(viewInfo);
		}
		if (sevenMelt.getmDirectorTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenMelt.getmDirectorTime());
			viewInfo.setContent(sevenMelt.getmDirector());
			list.add(viewInfo);
		}
		if (sevenMelt.getmManagerTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenMelt.getmManagerTime());
			viewInfo.setContent(sevenMelt.getmManager());
			list.add(viewInfo);
		}
		map.put("status", 0);
		map.put("data", list);
		return map;
	}

	/*
	 * 分页报销申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenMeltList", method = RequestMethod.GET)
	public Map<String, Object> getSevenMeltList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer mSid, Integer mState, String mApplyTime, String mItems) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenMelt> list = sevenMeltService.getSevenMeltList(page, limit, mSid, mState, mApplyTime, mItems);
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
	 * 分页自己报销申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfMeltList", method = RequestMethod.GET)
	public Map<String, Object> getSelfMeltList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer mState, String mApplyTime, String mItems, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenMelt> list = sevenMeltService.getSevenMeltList(page, limit, sevenAccount.getaSid(), mState,
				mApplyTime, mItems);
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
