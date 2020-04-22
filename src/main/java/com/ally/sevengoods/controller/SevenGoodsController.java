package com.ally.sevengoods.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ally.sevenclass.bean.SevenClass;
import com.ally.sevenclass.service.SevenClassService;
import com.ally.sevengoods.bean.SevenGoods;
import com.ally.sevengoods.bean.SevenGoodsInfo;
import com.ally.sevengoods.service.SevenGoodsService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenGoods")
public class SevenGoodsController {

	@Autowired
	private SevenGoodsService sevenGoodsService;
	@Autowired
	private SevenClassService sevenClassService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenGoods/sevenGoods-add";
	}

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenGoods/sevenGoods-update";
	}

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toInto")
	public String toInto() {
		return "view/sevenGoods/into";
	}

	/*
	 * 添加产品品名
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加产品品名")
	@RequestMapping(value = "/addSevenGoods", method = RequestMethod.POST)
	public Map<String, Object> addSevenClass(SevenGoods sevenGoods) {
		Map<String, Object> map = new HashMap<>();
		if (sevenGoods.getgCid() == null) {
			map.put("status", 3);
			map.put("msg", "产品类型不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenGoods.getgName())) {
			map.put("status", 3);
			map.put("msg", "产品名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenGoods.getgModel())) {
			map.put("status", 3);
			map.put("msg", "产品型号不能为空");
			return map;
		}
		if (sevenGoods.getgGid() == null) {
			map.put("status", 3);
			map.put("msg", "所属产品不能为空");
			return map;
		}
		Boolean result = sevenGoodsService.addSevenGoods(sevenGoods);
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

	@ResponseBody
	@ArchivesLog(operteContent = "批量添加产品品名")
	@RequestMapping(value = "/batchAddition", method = RequestMethod.POST)
	public Map<String, Object> batchAddition(@RequestBody String data) {
		List<SevenGoods> list = new ArrayList<>();
		List<SevenClass> className = sevenClassService.selectAllName();
		List<SevenGoods> goodsName = sevenGoodsService.selectAllName();
		List<SevenGoodsInfo> infos = parseString(data);
		for (int i = 0; i < infos.size(); i++) {
			SevenGoods sevenGoods = new SevenGoods();
			for (SevenClass sevenClass : className) {
				if (infos.get(i).getgCid().equals(sevenClass.getcName())) {
					sevenGoods.setgCid(sevenClass.getId());
				}
				continue;
			}
			sevenGoods.setgName(infos.get(i).getgName());
			sevenGoods.setgModel(infos.get(i).getgModel());
			for (SevenGoods goods : goodsName) {
				if (infos.get(i).getgGid() == null) {
					sevenGoods.setgGid(0);
				} else if (infos.get(i).getgGid().equals(goods.getgName())) {
					sevenGoods.setgGid(goods.getId());
				}
				continue;
			}
			list.add(sevenGoods);
		}
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenGoodsService.batchAddition(list);
		if (result) {
			map.put("status", 0);
			map.put("msg", "批量添加成功");
		} else {
			map.put("status", 2);
			map.put("msg", "批量添加失败");
		}
		return map;

	}

	private List<SevenGoodsInfo> parseString(String str) {
		List<SevenGoodsInfo> list = new ArrayList<>();
		JSONObject parseObject = JSONObject.parseObject(str);
		JSONArray jsonArray = parseObject.getJSONArray("data");
		for (int i = 1; i < jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			SevenGoodsInfo goods = JSON.toJavaObject(jsonObject, SevenGoodsInfo.class);
			list.add(goods);
		}
		return list;
	}

	/*
	 * 删除产品品名
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除产品品名")
	@RequestMapping(value = "/deleteSevenGoods", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenGoods(Integer id) {
		Map<String, Object> map = new HashMap<>();
		List<SevenGoods> list = sevenGoodsService.selectUnder(id);
		if (list.size()!=0) {
			map.put("status", 1);
			map.put("msg", "此产品下有附属产品,禁止删除");
			return map;
		} else {
			Boolean result = sevenGoodsService.deleteSevenGoods(id);
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
	 * 修改产品品名信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改产品品名")
	@RequestMapping(value = "/updateSevenGoods", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenGoods(SevenGoods sevenGoods) {
		Map<String, Object> map = new HashMap<>();
		if (sevenGoods.getgCid() == null) {
			map.put("status", 3);
			map.put("msg", "产品类型不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenGoods.getgName())) {
			map.put("status", 3);
			map.put("msg", "产品名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenGoods.getgModel())) {
			map.put("status", 3);
			map.put("msg", "产品型号不能为空");
			return map;
		}
		if (sevenGoods.getgGid() == null) {
			map.put("status", 3);
			map.put("msg", "所属产品不能为空");
			return map;
		}
		Boolean result = sevenGoodsService.updateSevenGoods(sevenGoods);
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
	 * 查看产品品名信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenGoodsById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenGoodsById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenGoods sevenGoods = sevenGoodsService.selectSevenGoods(id);
		map.put("status", 0);
		map.put("data", sevenGoods);
		return map;
	}

	/*
	 * 查询全部类型和产品
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAllCG", method = RequestMethod.GET)
	public Map<String, Object> selectAllCG() {
		Map<String, Object> map = new HashMap<>();
		List<SevenClass> classes = sevenClassService.selectAll();
		List<SevenGoods> goods = sevenGoodsService.selectAll();
		map.put("status", 0);
		map.put("data", goods);
		map.put("type", classes);
		return map;
	}
	
	/*查看全部产品
	 * */
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<SevenGoods> selectAll() {
		return  sevenGoodsService.selectAll();
	}
	/*
	 * 分页查询产品品名信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenGoodsList", method = RequestMethod.GET)
	public Map<String, Object> getSevenGoodsList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer gCid, String gName) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenGoods> list = sevenGoodsService.getSevenGoodsList(page, limit, gCid, gName);
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
