package com.ally.sevenvacate.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenvacate.bean.SevenVacate;
import com.ally.sevenvacate.service.SevenVacateService;
import com.ally.util.ArchivesLog;
import com.ally.util.FileUtil;
import com.ally.util.ViewInfo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenVacate")
public class SevenVacateController {

	@Autowired
	private SevenVacateService sevenVacateService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenVacate/sevenVacate-add";
	}

	/*
	 * 跳转到查看页
	 */
	@RequestMapping("/toView")
	public String toView() {
		return "view/sevenVacate/view";
	}

	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenVacate/index";
	}
	
	/*
	 * 跳转到部门审批列表
	 */
	@RequestMapping("/branchIndex")
	public String branchIndex() {
		return "view/sevenVacate/branch-index";
	}

	/*
	 * 跳转到部门审批
	 */
	@RequestMapping("/branchKnow")
	public String branchKnow() {
		return "view/sevenVacate/branch-know";
	}
	
	
	/*
	 * 跳转到主管审批列表
	 */
	@RequestMapping("/directorIndex")
	public String directorIndex() {
		return "view/sevenVacate/director-index";
	}

	/*
	 * 跳转到主管审批
	 */
	@RequestMapping("/directorKnow")
	public String directorKnow() {
		return "view/sevenVacate/director-know";
	}
	
	/*
	 * 跳转到经理审批列表
	 */
	@RequestMapping("/mangerIndex")
	public String mangerIndex() {
		return "view/sevenVacate/manger-index";
	}

	/*
	 * 跳转到经理审批
	 */
	@RequestMapping("/mangerKnow")
	public String mangerKnow() {
		return "view/sevenVacate/manger-know";
	}
	
	
	/*
	 * 添加请假申请
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加请假申请")
	@RequestMapping(value = "/addSevenVacate", method = RequestMethod.POST)
	public Map<String, Object> addSevenVacate(SevenVacate sevenVacate, HttpSession session,HttpServletRequest request,@RequestParam(value = "file") MultipartFile file) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		Map<String, String> queryMap = FileUtil.fileUp(file, "sevenVacate", request);
		String pfName = file.getOriginalFilename();
		sevenVacate.setvFileName(pfName);
		sevenVacate.setvUrl(queryMap.get("realPath"));
		sevenVacate.setvType(pfName.substring(pfName.lastIndexOf(".") + 1));
		sevenVacate.setvSid(sevenAccount.getaSid());
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenVacate.setvApplyTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sevenVacate.setvSate(0);
		if (StringUtils.isEmpty(sevenVacate.getvReason())) {
			map.put("status", 3);
			map.put("msg", "请假事由不能为空");
			return map;
		}
		if (sevenVacate.getvStart()==null) {
			map.put("status", 3);
			map.put("msg", "开始时间不能为空");
			return map;
		}
		if (sevenVacate.getvEnd()==null) {
			map.put("status", 3);
			map.put("msg", "结束时间不能为空");
			return map;
		}
		Boolean result = sevenVacateService.addSevenVacate(sevenVacate);
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
	 * */
	@ResponseBody
	@ArchivesLog(operteContent = "部门审批请假申请")
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public Map<String, Object> addBranch(SevenVacate sevenVacate) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenVacate.setvBranchTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenVacateService.addBranch(sevenVacate);
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
	 * */
	@ResponseBody
	@ArchivesLog(operteContent = "主管审批请假申请")
	@RequestMapping(value = "/addDirector", method = RequestMethod.POST)
	public Map<String, Object> addDirector(SevenVacate sevenVacate) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenVacate.setvDirectorTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenVacateService.addDirector(sevenVacate);
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
	 * */
	@ResponseBody
	@ArchivesLog(operteContent = "经理审批请假申请")
	@RequestMapping(value = "/addManger", method = RequestMethod.POST)
	public Map<String, Object> addManger(SevenVacate sevenVacate) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenVacate.setvDirectorTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenVacateService.addManger(sevenVacate);
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
	 * 查看请假申请
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenVacate", method = RequestMethod.GET)
	public Map<String, Object> selectSevenVacate(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenVacate sevenVacate = sevenVacateService.selectSevenVacate(id);
		List<ViewInfo> list = new ArrayList<ViewInfo>();
		if (sevenVacate.getvApplyTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenVacate.getvApplyTime());
			viewInfo.setContent("提交申请");
			list.add(viewInfo);
		} 
		if (sevenVacate.getvBranchTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenVacate.getvBranchTime());
			viewInfo.setContent(sevenVacate.getvBranch());
			list.add(viewInfo);
		} 
		if (sevenVacate.getvDirectorTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenVacate.getvDirectorTime());
			viewInfo.setContent(sevenVacate.getvDirector());
			list.add(viewInfo);
		} 
		if (sevenVacate.getvManagerTime() != null) {
			ViewInfo viewInfo = new ViewInfo();
			viewInfo.setTime(sevenVacate.getvManagerTime());
			viewInfo.setContent(sevenVacate.getvManager());
			list.add(viewInfo);
		}
		map.put("status", 0);
		map.put("data", list);
		return map;
	}

	/*
	 * 分页请假申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenVacatetList", method = RequestMethod.GET)
	public Map<String, Object> getSevenVacatetList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer vSid, Integer vSate, String vStart, String vEnd) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenVacate> list = sevenVacateService.getSevenVacatetList(page, limit, vSid, vSate, vStart, vEnd);
		map.put("status", 0);
		map.put("message", "成功");
		map.put("data", list.getList());
		map.put("total", list.getTotal());
		return map;
	}

	/*
	 * 分页查询自己请假申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfVacatetList", method = RequestMethod.GET)
	public Map<String, Object> getSelfVacatetList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer vSate, String vStart, String vEnd, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenVacate> list = sevenVacateService.getSevenVacatetList(page, limit, sevenAccount.getaSid(), vSate,
				vStart, vEnd);
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
