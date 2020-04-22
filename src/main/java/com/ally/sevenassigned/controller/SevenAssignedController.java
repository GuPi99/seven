package com.ally.sevenassigned.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.ally.sevenassigned.bean.SevenAssigned;
import com.ally.sevenassigned.service.SevenAssignedService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenAssigned")
public class SevenAssignedController {

	@Autowired
	private SevenAssignedService sevenAssignedService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenAssigned/sevenAssigned-add";
	}
	
	/*
	 * 跳转到首页页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenAssigned/index";
	}

	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenAssigned/sevenAssigned-update";
	}

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/selfIndex")
	public String selfIndex() {
		return "view/sevenAssigned/self-index";
	}
	
	/*
	 * 修改指派工作状态
	 * */
	@ResponseBody
	@ArchivesLog(operteContent = "指派工作是否完成")
	@RequestMapping(value = "/updateState", method = RequestMethod.POST)
	public Map<String, Object> updateState(SevenAssigned sevenAssigned) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenAssignedService.updateState(sevenAssigned);
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
	 * 添加指派工作
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加指派工作")
	@RequestMapping(value = "/addSevenAssigned", method = RequestMethod.POST)
	public Map<String, Object> addSevenAssigned(SevenAssigned sevenAssigned) {
		Map<String, Object> map = new HashMap<>();
		sevenAssigned.setaState(0);
		sevenAssigned.setaRead(0);
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenAssigned.setaDatetime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sevenAssigned.getaSid()==null) {
			map.put("status", 3);
			map.put("msg", "指派员工不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenAssigned.getaWork())) {
			map.put("status", 3);
			map.put("msg", "工作内容不能为空");
			return map;
		}
		Boolean result = sevenAssignedService.addSevenAssigned(sevenAssigned);
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
	 * 删除指派工作
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除指派工作")
	@RequestMapping(value = "/deleteSevenAssigned", method = RequestMethod.POST)
	public Map<String, Object> deleteSevenAssigned(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenAssignedService.deleteSevenAssigned(id);
		if (result) {
			map.put("status", 0);
			map.put("msg", "删除成功");
		} else {
			map.put("status", 1);
			map.put("msg", "删除失败");
		}
		return map;
	}

	/*
	 * 修改指派工作
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改指派工作")
	@RequestMapping(value = "/updateSevenAssigned", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenAssigned(SevenAssigned sevenAssigned) {
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dFormat.format(System.currentTimeMillis());
		try {
			sevenAssigned.setaDatetime(dFormat.parse(format));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sevenAssigned.getaSid()==null) {
			map.put("status", 3);
			map.put("msg", "指派员工不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenAssigned.getaWork())) {
			map.put("status", 3);
			map.put("msg", "工作内容不能为空");
			return map;
		}
		sevenAssigned.setaRead(0);
		Boolean result = sevenAssignedService.updateSevenAssigned(sevenAssigned);
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
	 * 查看指派工作
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenAssignedById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenAssignedById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenAssigned sevenAssigned = sevenAssignedService.selectSevenAssignedById(id);
		map.put("status", 0);
		map.put("data", sevenAssigned);
		return map;
	}
	
	/*
	 * 查看指派工作状态
	 */
	@ResponseBody
	@RequestMapping(value = "/updateReadStatus", method = RequestMethod.GET)
	public Map<String, Object> updateReadStatus(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenAssignedService.updateReadStatus(id);
		if (result) {
			map.put("status", 0);
			return map;
		} else {
			map.put("status", 1);
			return map;
		}
	}

	/*
	 * 分页指派工作
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenAssignedList", method = RequestMethod.GET)
	public Map<String, Object> getSevenAssignedList(@RequestParam(required = true, defaultValue = "1") Integer page,Integer limit,Integer aState,Integer aSid,String aWork) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenAssigned> list = sevenAssignedService.getSevenAssignedList(page,limit,aState,aSid,aWork);
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
	 * 指派自己的工作
	 */
	@ResponseBody
	@RequestMapping(value = "/getSelfAssignedList", method = RequestMethod.GET)
	public Map<String, Object> getSelfAssignedList(@RequestParam(required = true, defaultValue = "1") Integer page,Integer limit,Integer aState,String aWork,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		PageInfo<SevenAssigned> list = sevenAssignedService.getSevenAssignedList(page,limit,aState,sevenAccount.getaSid(),aWork);
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
	 * 首页显示指派工作
	 */
	@ResponseBody
	@RequestMapping(value = "/getIndexList", method = RequestMethod.GET)
	public Map<String, Object> getIndexList(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		List<SevenAssigned> list = sevenAssignedService.getIndexList(sevenAccount.getaSid());
		Integer count=sevenAssignedService.getIndexCount(sevenAccount.getaSid());
		if (list==null) {
			map.put("data", null);
			map.put("total", null);
		}else {
			map.put("data", list);
			map.put("total", count);
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
