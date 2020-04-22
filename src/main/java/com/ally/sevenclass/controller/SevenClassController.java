package com.ally.sevenclass.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenclass.bean.SevenClass;
import com.ally.sevenclass.service.SevenClassService;
import com.ally.sevengoods.bean.SevenGoods;
import com.ally.sevengoods.service.SevenGoodsService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenClass")
public class SevenClassController {

	@Autowired
	private SevenClassService sevenClassService;
	@Autowired
	private SevenGoodsService sevenGoodsService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenClass/sevenClass-add";
	}

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenClass/sevenClass-update";
	}

	/*
	 * 添加产品类型
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加产品类型")
	@RequestMapping(value = "/addSevenClass", method = RequestMethod.POST)
	public Map<String, Object> addSevenClass(SevenClass sevenClass) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenClass.getcName())) {
			map.put("status", 3);
			map.put("msg", "名称不能为空");
			return map;
		}
		Boolean result = sevenClassService.addSevenClass(sevenClass);
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
	 * 删除产品类型
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除产品类型")
	@RequestMapping(value = "/deleteSevenClass", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenClass(Integer id) {
		Map<String, Object> map = new HashMap<>();
		// 查看此类型下是否存在产品
		List<SevenGoods> list = sevenGoodsService.selectGoods(id);
		if (list.size()!=0) {
			map.put("status", 1);
			map.put("msg", "此类型下有产品,禁止删除");
			return map;
		} else {
			Boolean result = sevenClassService.deleteSevenClass(id);
			if (result) {
				map.put("status", 0);
				map.put("msg", "删除成功");
				return map;
			} else {
				map.put("status", 1);
				map.put("msg", "删除失败");
				return map;
			}
		}
	}

	/*
	 * 修改产品类型信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改产品类型")
	@RequestMapping(value = "/updateSevenClass", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenClass(SevenClass sevenClass) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenClass.getcName())) {
			map.put("status", 3);
			map.put("msg", "名称不能为空");
			return map;
		}
		Boolean result = sevenClassService.updateSevenClass(sevenClass);
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
	 * 查询全部类型
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public Map<String, Object> selectAll() {
		Map<String, Object> map = new HashMap<>();
		List<SevenClass> list = sevenClassService.selectAll();
		map.put("status", 0);
		map.put("data", list);
		return map;
	}

	/*
	 * 查看产品类型信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenClassById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenClassById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenClass sevenClass = sevenClassService.selectSevenClass(id);
		map.put("status", 0);
		map.put("data", sevenClass);
		return map;
	}

	/*
	 * 分页查询产品类型信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenClassList", method = RequestMethod.GET)
	public Map<String, Object> getSevenClassList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String cName) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenClass> list = sevenClassService.getSevenClassList(page, limit, cName);
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
