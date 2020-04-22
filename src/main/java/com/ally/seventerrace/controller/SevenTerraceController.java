package com.ally.seventerrace.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.seventerrace.bean.SevenTerrace;
import com.ally.seventerrace.service.SevenTerraceService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenTerrace")
public class SevenTerraceController {

	@Autowired
	private SevenTerraceService sevenTerraceService;
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenTerrace/sevenTerrace-add";
	}
	
	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenTerrace/index";
	}

	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenTerrace/sevenTerrace-update";
	}

	/*
	 * 上传、申请编辑、申请删除企业平台
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "上传、申请编辑、申请删除企业平台")
	@RequestMapping(value = "/changeState", method = RequestMethod.GET)
	public Map<String, Object> changeState(Integer id, Integer tState) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenTerraceService.changeState(id, tState);
		if (result) {
			if (tState == -2) {
				map.put("status", 0);
				map.put("msg", "申请删除成功");
			} else if (tState == -1) {
				map.put("status", 0);
				map.put("msg", "申请编辑成功");
			} else if (tState == 1) {
				map.put("status", 0);
				map.put("msg", "上传成功");
			}
		} else {
			if (tState == -2) {
				map.put("status", 3);
				map.put("msg", "申请删除失败");
			} else if (tState == -1) {
				map.put("status", 3);
				map.put("msg", "申请编辑失败");
			} else if (tState == 1) {
				map.put("status", 3);
				map.put("msg", "上传失败");
			}
		}
		return map;
	}

	/*
	 * 添加企业平台
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加企业平台")
	@RequestMapping(value = "/addSevenTerrace", method = RequestMethod.POST)
	public Map<String, Object> addSevenTerrace(SevenTerrace sevenTerrace) {
		Map<String, Object> map = new HashMap<>();
		sevenTerrace.settState(0);
		if (sevenTerrace.gettFid()==null) {
			map.put("status", 3);
			map.put("msg", "所属企业不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTerrace.gettName())) {
			map.put("status", 3);
			map.put("msg", "平台名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTerrace.gettUrl())) {
			map.put("status", 3);
			map.put("msg", "平台地址不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTerrace.gettEmail())) {
			map.put("status", 3);
			map.put("msg", "注册邮箱不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTerrace.gettPaw())) {
			map.put("status", 3);
			map.put("msg", "密码不能为空");
			return map;
		}
		Boolean result = sevenTerraceService.addSevenTerrace(sevenTerrace);
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
	 * 删除企业平台
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除企业平台")
	@RequestMapping(value = "/deleteSevenTerrace", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenTerrace(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenTerraceService.deleteSevenTerrace(id);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
		} else {
			map.put("status", 3);
			map.put("msg", "添加失败");
		}
		return map;
	}

	/*
	 * 修改企业平台
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改企业平台")
	@RequestMapping(value = "/updateSevenTerrace", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenTerrace(SevenTerrace sevenTerrace) {
		Map<String, Object> map = new HashMap<>();
		if (sevenTerrace.gettFid()==null) {
			map.put("status", 3);
			map.put("msg", "所属企业不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTerrace.gettName())) {
			map.put("status", 3);
			map.put("msg", "平台名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTerrace.gettUrl())) {
			map.put("status", 3);
			map.put("msg", "平台地址不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTerrace.gettEmail())) {
			map.put("status", 3);
			map.put("msg", "注册邮箱不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenTerrace.gettPaw())) {
			map.put("status", 3);
			map.put("msg", "密码不能为空");
			return map;
		}
		Boolean result = sevenTerraceService.updateSevenTerrace(sevenTerrace);
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
	 * 查看企业平台
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenTerraceById", method = RequestMethod.GET)
	public Map<String, Object>  selectSevenTerraceById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenTerrace sevenTerrace = sevenTerraceService.selectSevenTerraceById(id);
		map.put("status", 0);
		map.put("data", sevenTerrace);
		return map;
	}


	/*
	 * 分页企业平台
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenTerraceList", method = RequestMethod.GET)
	public Map<String, Object> getSevenTerraceList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer tFid,String tName) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenTerrace> list = sevenTerraceService.getSevenTerraceList(page, limit, tFid,tName);
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
