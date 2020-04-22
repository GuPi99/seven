package com.ally.sevenfirm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevencontact.bean.SevenContact;
import com.ally.sevencontact.service.SevenContactService;
import com.ally.sevenfirm.bean.SevenFirm;
import com.ally.sevenfirm.bean.SevenFirmInfo;
import com.ally.sevenfirm.service.SevenFirmService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenFirm")
public class SevenFirmController {

	@Autowired
	private SevenFirmService sevenFirmService;
	@Autowired
	private SevenContactService sevenContactService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenFirm/sevenFirm-add";
	}

	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenFirm/sevenFirm-update";
	}
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toInto")
	public String toInto() {
		return "view/sevenFirm/into";
	}

	/*
	 * 添加企业信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加企业信息")
	@RequestMapping(value = "/addSevenFirm", method = RequestMethod.POST)
	public Map<String, Object> addSevenFirm(SevenFirm sevenFirm, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		sevenFirm.setfSid(sevenAccount.getaSid());
		if (sevenFirm.getfFid() == null) {
			map.put("status", 3);
			map.put("msg", "所属公司不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfName())) {
			map.put("status", 3);
			map.put("msg", "公司名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfPhone())) {
			map.put("status", 3);
			map.put("msg", "公司电话不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfEmail())) {
			map.put("status", 3);
			map.put("msg", "公司邮箱不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfFax())) {
			map.put("status", 3);
			map.put("msg", "公司传真不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfEin())) {
			map.put("status", 3);
			map.put("msg", "公司税号不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfSite())) {
			map.put("status", 3);
			map.put("msg", "公司地址不能为空");
			return map;
		}
		Boolean result = sevenFirmService.addSevenFirm(sevenFirm);
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
	@ArchivesLog(operteContent = "批量添加客户")
	@RequestMapping(value = "/batchFirm", method = RequestMethod.POST)
	public Map<String, Object> batchAddition(@RequestBody String data,HttpSession session) {
		List<SevenFirm> list = new ArrayList<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		List<SevenFirm> firms =sevenFirmService.selectAll();
		List<SevenFirmInfo> infos = parseString(data);
		for (int i = 0; i < infos.size(); i++) {
			SevenFirm sevenFirm=new SevenFirm();
			for (SevenFirm sFirm : firms) {
				if (infos.get(i).getfFid().equals(sFirm.getfName())) {
					sevenFirm.setfFid(sFirm.getId());
				}else {
					sevenFirm.setfFid(0);
				}
				break;
			}
			sevenFirm.setfName(infos.get(i).getfName());
			sevenFirm.setfPhone(infos.get(i).getfPhone());
			sevenFirm.setfEmail(infos.get(i).getfEmail());
			sevenFirm.setfFax(infos.get(i).getfFax());
			sevenFirm.setfEin(infos.get(i).getfEin());
			sevenFirm.setfSite(infos.get(i).getfSite());
			sevenFirm.setfSid(sevenAccount.getaSid());
			list.add(sevenFirm);
		}
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenFirmService.batchFirm(list);
		if (result) {
			map.put("status", 0);
			map.put("msg", "批量添加成功");
		} else {
			map.put("status", 2);
			map.put("msg", "批量添加失败");
		}
		return map;
	}

	private List<SevenFirmInfo> parseString(String str) {
		List<SevenFirmInfo> list = new ArrayList<>();
		JSONObject parseObject = JSONObject.parseObject(str);
		JSONArray jsonArray = parseObject.getJSONArray("data");
		for (int i = 1; i < jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			SevenFirmInfo sevenFirmInfo = JSON.toJavaObject(jsonObject, SevenFirmInfo.class);
			list.add(sevenFirmInfo);
		}
		return list;
	}
	/*
	 * 删除企业信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除企业信息")
	@RequestMapping(value = "/deleteSevenFirm", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenFirm(Integer id) {
		Map<String, Object> map = new HashMap<>();
		List<SevenFirm> list = sevenFirmService.selectUnderFirm(id);
		List<SevenContact> sList=sevenContactService.selectContactList(id);
		if (list.size()!=0) {
			map.put("status", 1);
			map.put("msg", "此公司旗下有附属公司，禁止删除");
			return map;
		}else if (sList.size()!=0) {
			map.put("status", 1);
			map.put("msg", "此公司旗下联系人，禁止删除");
			return map;
		}else {
			Boolean result = sevenFirmService.deleteSevenFirm(id);
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
	 * 修改企业信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改企业信息")
	@RequestMapping(value = "/updateSevenFirm", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenFirm(SevenFirm sevenFirm) {
		Map<String, Object> map = new HashMap<>();
		if (sevenFirm.getfFid() == null) {
			map.put("status", 3);
			map.put("msg", "所属公司不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfName())) {
			map.put("status", 3);
			map.put("msg", "公司名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfPhone())) {
			map.put("status", 3);
			map.put("msg", "公司电话不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfEmail())) {
			map.put("status", 3);
			map.put("msg", "公司邮箱不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfFax())) {
			map.put("status", 3);
			map.put("msg", "公司传真不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfEin())) {
			map.put("status", 3);
			map.put("msg", "公司税号不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenFirm.getfSite())) {
			map.put("status", 3);
			map.put("msg", "公司地址不能为空");
			return map;
		}
		Boolean result = sevenFirmService.updateSevenFirm(sevenFirm);
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
	 * 查询全部企业信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public Map<String, Object> selectAll() {
		Map<String, Object> map = new HashMap<>();
		List<SevenFirm> list = sevenFirmService.selectAll();
		map.put("status", 0);
		map.put("data", list);
		return map;
	}

	/*
	 * 查看企业信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenFirmById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenFirmById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenFirm sevenFirm = sevenFirmService.selectSevenFirm(id);
		map.put("status", 0);
		map.put("data", sevenFirm);
		return map;
	}

	/*
	 * 分页查询企业信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenFirmList", method = RequestMethod.GET)
	public Map<String, Object> getSevenFirmList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String fName) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenFirm> list = sevenFirmService.getSevenFirmList(page, limit, fName);
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
