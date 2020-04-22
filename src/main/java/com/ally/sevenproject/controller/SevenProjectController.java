package com.ally.sevenproject.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenProjectCheck.bean.SevenProjectCheck;
import com.ally.sevenProjectCheck.service.SevenProjectCheckService;
import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenproject.bean.SevenProject;
import com.ally.sevenproject.service.SevenProjectService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenProject")
public class SevenProjectController {

	@Autowired
	private SevenProjectService sevenProjectService;
	@Autowired
	private SevenProjectCheckService sevenProjectCheckService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenProject/sevenProject-add";
	}

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProject/index";
	}
	
	
	/*
	 * 跳转到项目查看列表页
	 */
	@RequestMapping("/viewIndex")
	public String viewIndex() {
		return "view/sevenProject/view-index";
	}
	
	/*
	 * 跳转到项目查看列表页
	 */
	@RequestMapping("/viewSelect")
	public String viewSelect() {
		return "view/sevenProject/view-select";
	}
	
	/*
	 * 跳转到部门审批列表
	 */
	@RequestMapping("/branchIndex")
	public String branchIndex() {
		return "view/sevenProject/branch-index";
	}


	/*
	 * 跳转到主管审批列表
	 */
	@RequestMapping("/directorIndex")
	public String directorIndex() {
		return "view/sevenProject/director-index";
	}

	/*
	 * 跳转到经理审批列表
	 */
	@RequestMapping("/mangerIndex")
	public String mangerIndex() {
		return "view/sevenProject/manger-index";
	}
	
	/*
	 * 跳转到查看页
	 */
	@RequestMapping("/toSelect")
	public String selectProject() {
		return "view/sevenProject/sevenProject-select";
	}
	
	/*
	 * 跳转到部门审批
	 */
	@RequestMapping("/branchKnow")
	public String branchKnow() {
		return "view/sevenProject/branch-know";
	}
	
	/*
	 * 跳转到部门查看审批页
	 */
	@RequestMapping("/selectBranch")
	public String selectBranch() {
		return "view/sevenProject/sevenProject-selectBranch";
	}
	
	/*
	 * 跳转到主管审批
	 */
	@RequestMapping("/directorKnow")
	public String directorKnow() {
		return "view/sevenProject/director-know";
	}

	/*
	 * 跳转到主管查看审批页
	 */
	@RequestMapping("/selectDirector")
	public String selectDirector() {
		return "view/sevenProject/sevenProject-selectDirector";
	}

	/*
	 * 跳转到经理审批
	 */
	@RequestMapping("/mangerKnow")
	public String mangerKnow() {
		return "view/sevenProject/manger-know";
	}
	
	/*
	 * 跳转到经理查看审批页
	 */
	@RequestMapping("/selectManger")
	public String selectManger() {
		return "view/sevenProject/sevenProject-selectManger";
	}

	/*
	 * 添加项目信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加项目信息")
	@RequestMapping(value = "/addSevenProject", method = RequestMethod.POST)
	public Map<String, Object> addSevenProject(SevenProject sevenProject, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenProject.setpDatetime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sevenProject.getpDate()==null) {
			map.put("status", 3);
			map.put("msg", "拟定日期不能为空");
			return map;
		}
		if (sevenProject.getpFid()==null) {
			map.put("status", 3);
			map.put("msg", "客户不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenProject.getpConditions())) {
			map.put("status", 3);
			map.put("msg", "生效条件不能为空");
			return map;
		}
		sevenProject.setpSid(sevenAccount.getaSid());
		Boolean result = sevenProjectService.addSevenProject(sevenProject);
		SevenProjectCheck sevenProjectCheck=new SevenProjectCheck();
		sevenProjectCheck.setPcPid(sevenProject.getId());
		sevenProjectCheck.setPcState(0);
		sevenProjectCheck.setPcOther(0);
		try {
			sevenProjectCheck.setPcTime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sevenProjectCheck.setPcSid(sevenAccount.getaSid());
		sevenProjectCheck.setPcEvaluation("添加项目申请");
		Boolean flag = sevenProjectCheckService.addProjectCheck(sevenProjectCheck);
		if (result && flag) {
			map.put("status", 0);
			map.put("data", sevenProject.getId());
			map.put("msg", "添加成功");
			return map;
		} else {
			map.put("status", 3);
			map.put("msg", "添加失败");
			return map;
		}
	}

	/*
	 * 查看项目信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenProjectById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenProjectById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenProject sevenProject = sevenProjectService.selectSevenProjectById(id);
		map.put("status", 0);
		map.put("data", sevenProject);
		return map;
	}
	

	/*
	 * 分页查询项目信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenProjectList", method = RequestMethod.GET)
	public Map<String, Object> getSevenProjectList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer pcState,Integer pFid,String pDate) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenProject> list = sevenProjectService.getSevenProjectList(page, limit, pcState,pFid,pDate);
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
