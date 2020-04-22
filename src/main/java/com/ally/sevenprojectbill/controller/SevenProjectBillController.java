package com.ally.sevenprojectbill.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenproject.bean.SevenProject;
import com.ally.sevenproject.service.SevenProjectService;
import com.ally.sevenprojectbill.bean.SevenProjectBill;
import com.ally.sevenprojectbill.service.SevenProjectBillService;
import com.ally.util.ArchivesLog;
import com.ally.util.ViewInfo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenProjectBill")
public class SevenProjectBillController {

	@Autowired
	private SevenProjectBillService sevenProjectBillService;
	@Autowired
	private SevenProjectService sevenProjectService;
	
	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProjectBill/index";
	}
	/*
	 * 跳转到部门审批列表
	 */
	@RequestMapping("/branchIndex")
	public String branchIndex() {
		return "view/sevenProjectBill/branch-index";
	}

	/*
	 * 跳转到部门审批
	 */
	@RequestMapping("/branchKnow")
	public String branchKnow() {
		return "view/sevenProjectBill/branch-know";
	}
	
	/*
	 * 跳转到部门审批
	 */
	@RequestMapping("/branchSelect")
	public String branchSelect() {
		return "view/sevenProjectBill/branch-select";
	}

	/*
	 * 跳转到主管审批列表
	 */
	@RequestMapping("/directorIndex")
	public String directorIndex() {
		return "view/sevenProjectBill/director-index";
	}
	
	/*
	 * 跳转到主管审批
	 */
	@RequestMapping("/directorSelect")
	public String directorSelect() {
		return "view/sevenProjectBill/director-select";
	}


	/*
	 * 跳转到主管审批
	 */
	@RequestMapping("/directorKnow")
	public String directorKnow() {
		return "view/sevenProjectBill/director-know";
	}
	
	/*
	 * 跳转到主管审批
	 */
	@RequestMapping("/mangerSelect")
	public String mangerSelect() {
		return "view/sevenProjectBill/manger-select";
	}

	/*
	 * 跳转到经理审批列表
	 */
	@RequestMapping("/mangerIndex")
	public String mangerIndex() {
		return "view/sevenProjectBill/manger-index";
	}

	/*
	 * 跳转到经理审批
	 */
	@RequestMapping("/mangerKnow")
	public String mangerKnow() {
		return "view/sevenProjectBill/manger-know";
	}
	
	/*
	 * 添加开票申请
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加项目开票申请")
	@RequestMapping(value = "/addSevenProjectBill", method = RequestMethod.POST)
	public Map<String, Object> addSevenProjectBill(SevenProjectBill sevenProjectBill) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenProjectBill.setPbTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sevenProjectBill.setPbState(0);
		Boolean result = sevenProjectBillService.addSevenProjectBill(sevenProjectBill);
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
	@ArchivesLog(operteContent = "部门审批开票申请")
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public Map<String, Object> addBranch(SevenProjectBill sevenProjectBill) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenProjectBill.setPbBranchTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenProjectBillService.addBranch(sevenProjectBill);
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
	@ArchivesLog(operteContent = "主管审批开票申请")
	@RequestMapping(value = "/addDirector", method = RequestMethod.POST)
	public Map<String, Object> addDirector(SevenProjectBill sevenProjectBill) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenProjectBill.setPbDirectorTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenProjectBillService.addDirector(sevenProjectBill);
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
	@ArchivesLog(operteContent = "主管审批开票申请")
	@RequestMapping(value = "/addManger", method = RequestMethod.POST)
	public Map<String, Object> addManger(SevenProjectBill sevenProjectBill) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenProjectBill.setPbManagerTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenProjectBillService.addManger(sevenProjectBill);
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
	 * 开票申请详情
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenProjectBill", method = RequestMethod.GET)
	public Map<String, Object> selectSevenProjectBill(Integer pbPid) {
		Map<String, Object> map = new HashMap<>();
		SevenProjectBill sevenProjectBill = sevenProjectBillService.selectSevenProjectBill(pbPid);
		List<ViewInfo> list = new ArrayList<ViewInfo>();
		if (sevenProjectBill!=null) {
			if (sevenProjectBill.getPbTime() != null) {
				ViewInfo viewInfo = new ViewInfo();
				viewInfo.setTime(sevenProjectBill.getPbTime());
				viewInfo.setContent("提交申请");
				list.add(viewInfo);
			}
			if (sevenProjectBill.getPbBranchTime() != null) {
				ViewInfo viewInfo = new ViewInfo();
				viewInfo.setTime(sevenProjectBill.getPbBranchTime());
				viewInfo.setContent(sevenProjectBill.getPbBranch());
				list.add(viewInfo);
			}
			if (sevenProjectBill.getPbDirectorTime() != null) {
				ViewInfo viewInfo = new ViewInfo();
				viewInfo.setTime(sevenProjectBill.getPbDirectorTime());
				viewInfo.setContent(sevenProjectBill.getPbDirector());
				list.add(viewInfo);
			}
			if (sevenProjectBill.getPbManagerTime() != null) {
				ViewInfo viewInfo = new ViewInfo();
				viewInfo.setTime(sevenProjectBill.getPbManagerTime());
				viewInfo.setContent(sevenProjectBill.getPbManager());
				list.add(viewInfo);
			}
		}
		
		map.put("status", 0);
		map.put("data", list);
		return map;
	}
	
	/*
	 * 分页查询项目信息的开票信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenProjectBillList", method = RequestMethod.GET)
	public Map<String, Object> getSevenProjectBillList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer pFid,String pDate,Integer pbState) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenProject> list = sevenProjectService.getSevenProjectBillList(page, limit,pFid,pDate,pbState);
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
