package com.ally.sevenprofile.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenprofile.bean.SevenProfile;
import com.ally.sevenprofile.service.SevenProfileService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenProfile")
public class SevenProfileController {

	@Autowired
	private SevenProfileService sevenProfileService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenProfile/sevenProfile-add";
	}

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProfile/index";
	}

	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenProfile/sevenProfile-update";
	}

	/*
	 * 添加收货地址
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加收货地址")
	@RequestMapping(value = "/addSevenProfile", method = RequestMethod.POST)
	public Map<String, Object> addSevenProfile(SevenProfile sevenProfile) {
		Map<String, Object> map = new HashMap<>();
		if (sevenProfile.getpFid() == null) {
			map.put("status", 3);
			map.put("msg", "所属企业不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenProfile.getpSite())) {
			map.put("status", 3);
			map.put("msg", "企业收货地址不能为空");
			return map;
		}
		Boolean result = sevenProfileService.addSevenProfile(sevenProfile);
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
	 * 删除收货地址
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除收货地址")
	@RequestMapping(value = "/deleteSevenProfile", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenProfile(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenProfileService.deleteSevenProfile(id);
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
	 * 修改收货地址
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改收货地址")
	@RequestMapping(value = "/updateSevenProfile", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenProfile(SevenProfile sevenProfile) {
		Map<String, Object> map = new HashMap<>();
		if (sevenProfile.getpFid() == null) {
			map.put("status", 3);
			map.put("msg", "所属企业不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenProfile.getpSite())) {
			map.put("status", 3);
			map.put("msg", "企业收货地址不能为空");
			return map;
		}
		Boolean result = sevenProfileService.updateSevenProfile(sevenProfile);
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
	 * 查看收货地址
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenProfileById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenProfileById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenProfile sevenProfile = sevenProfileService.selectSevenProfile(id);
		map.put("status", 0);
		map.put("data", sevenProfile);
		return map;
	}

	/*
	 * 分页查询收货地址
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenProfileList", method = RequestMethod.GET)
	public Map<String, Object> getSevenProfileList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer pFid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenProfile> list = sevenProfileService.getSevenProfileList(page, limit, pFid);
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
