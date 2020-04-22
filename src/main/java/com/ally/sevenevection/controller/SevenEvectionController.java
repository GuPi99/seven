package com.ally.sevenevection.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevendailyplan.bean.SevenDailyPlan;
import com.ally.sevendailyplan.service.SevenDailyPlanService;
import com.ally.sevenevection.bean.SevenEvection;
import com.ally.sevenevection.service.SevenEvectionService;
import com.ally.util.ArchivesLog;
import com.ally.util.ViewInfo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("sevenEvection")
public class SevenEvectionController {

	@Autowired
	private SevenEvectionService sevenEvectionService;
	@Autowired
	private SevenDailyPlanService sevenDailyPlanService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenEvection/sevenEvection-add";
	}
	
	/*
	 * 跳转到查看页
	 */
	@RequestMapping("/select")
	public String select() {
		return "view/sevenEvection/sevenEvection-select";
	}

	/*
	 * 跳转到部门查看审批页
	 */
	@RequestMapping("/selectBranch")
	public String selectBranch() {
		return "view/sevenEvection/sevenEvection-selectBranch";
	}

	/*
	 * 跳转到主管查看审批页
	 */
	@RequestMapping("/selectDirector")
	public String selectDirector() {
		return "view/sevenEvection/sevenEvection-selectDirector";
	}

	/*
	 * 跳转到经理查看审批页
	 */
	@RequestMapping("/selectManger")
	public String selectManger() {
		return "view/sevenEvection/sevenEvection-selectManger";
	}

	/*
	 * 跳转到查看审批页
	 */
	@RequestMapping("/toView")
	public String toView() {
		return "view/sevenEvection/view";
	}

	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenEvection/index";
	}

	/*
	 * 跳转到部门审批列表
	 */
	@RequestMapping("/branchIndex")
	public String branchIndex() {
		return "view/sevenEvection/branch-index";
	}

	/*
	 * 跳转到部门审批
	 */
	@RequestMapping("/branchKnow")
	public String branchKnow() {
		return "view/sevenEvection/branch-know";
	}

	/*
	 * 跳转到主管审批列表
	 */
	@RequestMapping("/directorIndex")
	public String directorIndex() {
		return "view/sevenEvection/director-index";
	}

	/*
	 * 跳转到主管审批
	 */
	@RequestMapping("/directorKnow")
	public String directorKnow() {
		return "view/sevenEvection/director-know";
	}

	/*
	 * 跳转到经理审批列表
	 */
	@RequestMapping("/mangerIndex")
	public String mangerIndex() {
		return "view/sevenEvection/manger-index";
	}

	/*
	 * 跳转到经理审批
	 */
	@RequestMapping("/mangerKnow")
	public String mangerKnow() {
		return "view/sevenEvection/manger-know";
	}

	/*
	 * 添加出差申请
	 */
	@ResponseBody
	@Transactional
	@ArchivesLog(operteContent = "添加出差申请")
	@RequestMapping(value = "/addSevenEvection", method = RequestMethod.POST)
	public Map<String, Object> addSevenEvection(SevenEvection sevenEvection, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenEvection.seteSid(sevenAccount.getaSid());
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenEvection.seteApplyTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sevenEvection.seteState(0);
		if (StringUtils.isEmpty(sevenEvection.geteGoal())) {
			map.put("status", 3);
			map.put("msg", "出差目的不能为空");
			return map;
		}
		Boolean result = sevenEvectionService.addSevenVacate(sevenEvection);
		if (result) {
			SevenDailyPlan sevenDailyPlan=new SevenDailyPlan();
			sevenDailyPlan.setDpSid(sevenAccount.getaSid());
			sevenDailyPlan.setDpType(1);
			sevenDailyPlan.setDpWhere(2);
			sevenDailyPlan.setDpDate("出差");
			sevenDailyPlan.setDpWork("出差");
			sevenDailyPlan.setDpEid(sevenEvection.getId());
			Boolean flag=sevenDailyPlanService.addSevenDailyPlan(sevenDailyPlan);
			if (flag) {
				map.put("status", 0);
				map.put("msg", "添加成功");
				return map;
			} else {
				map.put("status", 3);
				map.put("msg", "添加失败");
				return map;
			}
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
	@ArchivesLog(operteContent = "部门审批出差申请")
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public Map<String, Object> addBranch(SevenEvection sevenEvection) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenEvection.seteBranchTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenEvectionService.addBranch(sevenEvection);
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
	@ArchivesLog(operteContent = "主管审批出差申请")
	@RequestMapping(value = "/addDirector", method = RequestMethod.POST)
	public Map<String, Object> addDirector(SevenEvection sevenEvection) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenEvection.seteDirectorTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result = sevenEvectionService.addDirector(sevenEvection);
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
	@ArchivesLog(operteContent = "经理审批出差申请")
	@RequestMapping(value = "/addManger", method = RequestMethod.POST)
	public Map<String, Object> addManger(SevenEvection sevenEvection) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenEvection.seteManagerTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sevenEvection.geteManager());
		Boolean result = sevenEvectionService.addManger(sevenEvection);
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
	 * 查看出差申请
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenEvection", method = RequestMethod.GET)
	public Map<String, Object> selectSevenEvection(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenEvection sevenEvection = sevenEvectionService.selectSevenEvection(id);
		map.put("status", 0);
		map.put("data", sevenEvection);
		return map;
	}

	/*
	 * 查看出差申请进度
	 */
	@ResponseBody
	@RequestMapping(value = "/selectEvectionApproval", method = RequestMethod.GET)
	public Map<String, Object> selectEvectionApproval(Integer id) {
		Map<String, Object> map = new HashMap<>();
		if (id!=null) {
			SevenEvection sevenEvection = sevenEvectionService.selectSevenEvection(id);
			List<ViewInfo> list = new ArrayList<ViewInfo>();
			if (sevenEvection.geteApplyTime() != null) {
				ViewInfo viewInfo = new ViewInfo();
				viewInfo.setTime(sevenEvection.geteApplyTime());
				viewInfo.setContent("提交申请");
				list.add(viewInfo);
			}
			if (sevenEvection.geteBranchTime() != null) {
				ViewInfo viewInfo = new ViewInfo();
				viewInfo.setTime(sevenEvection.geteBranchTime());
				viewInfo.setContent(sevenEvection.geteBranch());
				list.add(viewInfo);
			}
			if (sevenEvection.geteDirectorTime() != null) {
				ViewInfo viewInfo = new ViewInfo();
				viewInfo.setTime(sevenEvection.geteDirectorTime());
				viewInfo.setContent(sevenEvection.geteDirector());
				list.add(viewInfo);
			}
			if (sevenEvection.geteManagerTime() != null) {
				ViewInfo viewInfo = new ViewInfo();
				viewInfo.setTime(sevenEvection.geteManagerTime());
				viewInfo.setContent(sevenEvection.geteManager());
				list.add(viewInfo);
			}
			map.put("status", 0);
			map.put("data", list);
		} else {
			map.put("status", 0);
			map.put("data", null);
		}
		
		return map;
	}

	/*
	 * 分页出差申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenEvectionList", method = RequestMethod.GET)
	public Map<String, Object> getSevenEvectionList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer eSid, Integer eState, String eGoal, String eApplyTime) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenEvection> list = sevenEvectionService.getSevenEvectionList(page, limit, eSid, eState, eGoal,
				eApplyTime);
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
	 * 分页查询自己出差申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfEvectionList", method = RequestMethod.GET)
	public Map<String, Object> getSelfEvectionList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer eState, String eGoal, String eApplyTime, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenEvection> list = sevenEvectionService.getSevenEvectionList(page, limit, sevenAccount.getaSid(),
				eState, eGoal, eApplyTime);
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
	 * 首页显示出差申请
	 */
	@ResponseBody
	@RequestMapping(value = "/getIndexList", method = RequestMethod.GET)
	public Map<String, Object> getIndexList(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		Calendar calendar3 = Calendar.getInstance();
		calendar3.add(Calendar.DAY_OF_MONTH, + 3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String after = sdf.format(calendar3.getTime());
        String now=sdf.format(System.currentTimeMillis());
		List<SevenEvection> list = sevenEvectionService.getIndexList(sevenAccount.getaSid(),now,after);
		if (list==null) {
			map.put("data", null);
		}else {
			map.put("data", list);
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
	
}
