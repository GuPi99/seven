package com.ally.sevenprojectgoods.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevengoods.bean.SevenGoods;
import com.ally.sevengoods.service.SevenGoodsService;
import com.ally.sevenprojectgoods.bean.SevenProjectGoods;
import com.ally.sevenprojectgoods.service.SevenProjectGoodsService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenProjectGoods")
public class SevenProjectGoodsController {

	@Autowired
	private SevenProjectGoodsService sevenProjectGoodsService;
	@Autowired
	private SevenGoodsService sevenGoodsService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenProjectGoods/sevenProjectGoods-add";
	}
	
	/*
	 * 跳转到首页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenProjectGoods/index";
	}
	
	/*
	 * 跳转到查看配件信息
	 */
	@RequestMapping("/educe")
	public String educe() {
		return "view/sevenProjectGoods/educe";
	}

	/*
	 * 添加项目产品信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加项目产品信息")
	@RequestMapping(value = "/addSevenProjectGoods", method = RequestMethod.POST)
	public Map<String, Object> addSevenProjectGoods(SevenProjectGoods sevenProjectGoods) {
		Map<String, Object> map = new HashMap<>();
		if (sevenProjectGoods.getPgCid()==null) {
			map.put("status", 3);
			map.put("msg", "产品类型不能为空");
			return map;
		}
		if (sevenProjectGoods.getPgGid()==null) {
			map.put("status", 3);
			map.put("msg", "产品不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenProjectGoods.getPsName())) {
			map.put("status", 3);
			map.put("msg", "自定义名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenProjectGoods.getPgModel())) {
			map.put("status", 3);
			map.put("msg", "自定义型号不能为空");
			return map;
		}
		if (sevenProjectGoods.getPgNum()==null) {
			map.put("status", 3);
			map.put("msg", "需求数量不能为空");
			return map;
		}
		Boolean result = sevenProjectGoodsService.addSevenProjectGoods(sevenProjectGoods);
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
	 * 删除项目产品信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除项目产品信息")
	@RequestMapping(value = "/delectProjectGoods", method = RequestMethod.GET)
	public Map<String, Object> delectProjectGoods(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenProjectGoodsService.delectProjectGoods(id);
		if (result) {
			map.put("status", 0);
			map.put("msg", "删除成功");
		} else {
			map.put("status", 3);
			map.put("msg", "删除失败");
		}
		return map;
	}
	
	/*
	 * 分页查询项目产品信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenProjectGoodsList", method = RequestMethod.GET)
	public Map<String, Object> getSevenProjectGoodsList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit,Integer pgPid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenProjectGoods> list = null;
		if (pgPid==null) {
			map.put("data", null);
			map.put("total", null);
		}else {
			list=sevenProjectGoodsService.getSevenProjectGoodsList(page, limit, pgPid);
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
	
	/*
	 * 导出项目产品配件信息
	 */
	@ResponseBody
	@RequestMapping(value = "/exportGoods", method = RequestMethod.GET)
	public Map<String, Object> exportGoods(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit,Integer id) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenGoods> list = null;
		if (id==null) {
			map.put("data", null);
			map.put("total", null);
		}else {
			list=sevenGoodsService.getProjectGoodsList(page, limit, id);
			map.put("data", list.getList());
			map.put("total", list.getTotal());
		}
		map.put("status", 0);
		map.put("message", "成功");
		return map;
	}
	
}
