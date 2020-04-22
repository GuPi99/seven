package com.ally.sevenoffice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenoffice.bean.SevenOffice;
import com.ally.sevenoffice.service.SevenOfficeService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenOffice")
public class SevenOfficeController {

	@Autowired
	private SevenOfficeService sevenOfficeService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenOffice/sevenOffice-add";
	}

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenOffice/index";
	}

	
	/*
	 * 添加员工任职信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加员工任职信息")
	@Transactional
	@RequestMapping(value = "/addSvenOffice", method = RequestMethod.POST)
	public Map<String, Object> addSvenOffice(SevenOffice sevenOffice) {
		Map<String, Object> map = new HashMap<>();
		if (sevenOffice.getoSid()==null) {
			map.put("status", 3);
			map.put("msg", "员工不能为空");
			return map;
		}
		if (sevenOffice.getoBranch()==null) {
			map.put("status", 3);
			map.put("msg", "部门不能为空");
			return map;
		}
		if (sevenOffice.getoPost()==null) {
			map.put("status", 3);
			map.put("msg", "职位不能为空");
			return map;
		}
		if (sevenOffice.getoOffice()==null) {
			map.put("status", 3);
			map.put("msg", "任职日期不能为空");
			return map;
		}
		SevenOffice beforeOffice=sevenOfficeService.selectBefore(sevenOffice.getoSid());
		if (beforeOffice!=null) {
			Boolean result=sevenOfficeService.updateBeforeOffice(beforeOffice.getId(),sevenOffice.getoOffice());
			if (result) {
				Boolean flag = sevenOfficeService.addSvenOffice(sevenOffice);
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
		} else {
			Boolean flag = sevenOfficeService.addSvenOffice(sevenOffice);
			if (flag) {
				map.put("status", 0);
				map.put("msg", "添加成功");
				return map;
			} else {
				map.put("status", 3);
				map.put("msg", "添加失败");
				return map;
			}
		}
	}

	/*
	 * 删除员工任职信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除员工任职信息")
	@RequestMapping(value = "/deleteSevenOffice", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenOffice(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenOfficeService.deleteSevenOffice(id);
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
	 * 分页查询任职信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenOfficeList", method = RequestMethod.GET)
	public Map<String, Object> getSevenOfficeList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer oSid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenOffice> list = sevenOfficeService.getSevenOfficeList(page, limit, oSid);
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
