package com.ally.sevenvisit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenvisit.bean.SevenVisit;
import com.ally.sevenvisit.service.SevenVisitService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenVisit")
public class SevenVisitController {

	@Autowired
	private SevenVisitService sevenVisitService;
	
	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenVisit/index";
	}
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenVisit/sevenVisit-add";
	}
	
	/*
	 * 添加客户列表
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加出差申请的客户")
	@RequestMapping(value = "/addSevenVisit", method = RequestMethod.POST)
	public Map<String, Object> addSevenVisit(SevenVisit sevenVisit) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenVisitService.addSevenVisit(sevenVisit);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
		} else {
			map.put("status", 1);
			map.put("msg", "添加失败");
		}
		return map;
	}
	
	/*
	 * 删除客户列表
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除出差申请的客户")
	@RequestMapping(value = "/deleteSevenVisit", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenVisit(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenVisitService.deleteSevenVisit(id);
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
	 * 分页客户列表
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenVisitList", method = RequestMethod.GET)
	public Map<String, Object> getSevenVisitList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer vEid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenVisit> list = null;
		if (vEid==null) {
			list=null;
			map.put("data", null);
			map.put("total", null);
		}else {
			list=sevenVisitService.getSevenVisitList(page, limit,vEid);
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
}
