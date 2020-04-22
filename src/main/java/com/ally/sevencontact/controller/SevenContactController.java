package com.ally.sevencontact.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevencontact.bean.SevenContact;
import com.ally.sevencontact.service.SevenContactService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenContact")
public class SevenContactController {

	@Autowired
	private SevenContactService sevenContactService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenContact/sevenContact-add";
	}

	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenContact/index";
	}

	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenContact/sevenContact-update";
	}

	/*
	 * 添加企业联系人
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加企业联系人")
	@RequestMapping(value = "/addSevenContact", method = RequestMethod.POST)
	public Map<String, Object> addSevenContact(SevenContact sevenContact) {
		Map<String, Object> map = new HashMap<>();
		sevenContact.setcState(0);
		if (sevenContact.getcFid()==null) {
			map.put("status", 3);
			map.put("msg", "所属企业不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenContact.getcName())) {
			map.put("status", 3);
			map.put("msg", "姓名不能为空");
			return map;
		}
		if (sevenContact.getcSex()==null) {
			map.put("status", 3);
			map.put("msg", "性别不能为空");
			return map;
		}
		if (sevenContact.getcAge()==null) {
			map.put("status", 3);
			map.put("msg", "年龄不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenContact.getcPhone())) {
			map.put("status", 3);
			map.put("msg", "联系电话不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenContact.getcEmail())) {
			map.put("status", 3);
			map.put("msg", "联系邮箱不能为空");
			return map;
		}
		Boolean result = sevenContactService.addSevenContact(sevenContact);
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
	 * 上传、申请编辑、申请删除企业联系人
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "上传、申请编辑、申请删除企业联系人")
	@RequestMapping(value = "/changeState", method = RequestMethod.GET)
	public Map<String, Object> changeState(Integer id, Integer cState) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenContactService.changeState(id, cState);
		if (result) {
			if (cState == -2) {
				map.put("status", 0);
				map.put("msg", "申请删除成功");
			} else if (cState == -1) {
				map.put("status", 0);
				map.put("msg", "申请编辑成功");
			} else if (cState == 1) {
				map.put("status", 0);
				map.put("msg", "上传成功");
			}
		} else {
			if (cState == -2) {
				map.put("status", 3);
				map.put("msg", "申请删除失败");
			} else if (cState == -1) {
				map.put("status", 3);
				map.put("msg", "申请编辑失败");
			} else if (cState == 1) {
				map.put("status", 3);
				map.put("msg", "上传失败");
			}
		}
		return map;
	}

	/*
	 * 删除企业联系人
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除企业联系人")
	@RequestMapping(value = "/deleteSevenContact", method = RequestMethod.DELETE)
	public Map<String, Object> deleteSevenContact(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenContactService.deleteSevenContact(id);
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
	 * 修改企业联系人
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改企业联系人")
	@RequestMapping(value = "/updateSevenContact", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenContact(SevenContact sevenContact) {
		Map<String, Object> map = new HashMap<>();
		if (sevenContact.getcFid()==null) {
			map.put("status", 3);
			map.put("msg", "所属企业不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenContact.getcName())) {
			map.put("status", 3);
			map.put("msg", "姓名不能为空");
			return map;
		}
		if (sevenContact.getcSex()==null) {
			map.put("status", 3);
			map.put("msg", "性别不能为空");
			return map;
		}
		if (sevenContact.getcAge()==null) {
			map.put("status", 3);
			map.put("msg", "年龄不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenContact.getcPhone())) {
			map.put("status", 3);
			map.put("msg", "联系电话不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenContact.getcEmail())) {
			map.put("status", 3);
			map.put("msg", "联系邮箱不能为空");
			return map;
		}
		Boolean result = sevenContactService.updateSevenContact(sevenContact);
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
	 * 查看企业联系人
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenContactById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenContactById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenContact sevenContact = sevenContactService.selectSevenContact(id);
		map.put("status", 0);
		map.put("data", sevenContact);
		return map;
	}

	/*
	 * 分页查询产品类型信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenContactList", method = RequestMethod.GET)
	public Map<String, Object> getSevenContactList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer cFid, String cName) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenContact> list = sevenContactService.getSevenContactList(page, limit, cFid, cName);
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
