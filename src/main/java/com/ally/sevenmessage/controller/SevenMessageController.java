package com.ally.sevenmessage.controller;

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

import com.ally.sevenmessage.bean.SevenMessage;
import com.ally.sevenmessage.service.SevenMessageService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenMessage")
public class SevenMessageController {

	@Autowired
	private SevenMessageService sevenMessageService;

	/*
	 * 跳转到部门列表页
	 */
	@RequestMapping("/departIndex")
	public String departIndex() {
		return "view/sevenMessage/departIndex";
	}

	/*
	 * 跳转到部门添加页
	 */
	@RequestMapping("/toAddDepart")
	public String toAddDepart() {
		return "view/sevenMessage/depart-add";
	}

	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toDepartUpdate")
	public String toDepartUpdate() {
		return "view/sevenMessage/depart-update";
	}

	/*
	 * 跳转到职位列表页
	 */
	@RequestMapping("/positionIndex")
	public String positionIndex() {
		return "view/sevenMessage/positionIndex";
	}

	/*
	 * 跳转到职位添加页
	 */
	@RequestMapping("/toPositionAdd")
	public String toPositionAdd() {
		return "view/sevenMessage/position-add";
	}

	/*
	 * 跳转到职位修改页
	 */
	@RequestMapping("/toPositionUpdate")
	public String toPositionUpdate() {
		return "view/sevenMessage/position-update";
	}

	/*
	 * 添加部门或者职位
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加部门或者职位")
	@RequestMapping(value = "/addSevenMessage", method = RequestMethod.POST)
	public Map<String, Object> addSevenMessage(SevenMessage sevenMessage) {
		Map<String, Object> map = new HashMap<>();
		if (sevenMessage.getmType() == null) {
			map.put("status", 3);
			map.put("msg", "类型不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenMessage.getmName())) {
			map.put("status", 3);
			map.put("msg", "名称不能为空");
			return map;
		}
		Boolean result = sevenMessageService.addSevenMessage(sevenMessage);
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
	 * 删除部门或者职位
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除部门或者职位")
	@RequestMapping(value = "/deleteSevenMessage", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenMessage(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenMessageService.deleteSevenMessage(id);
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
	 * 修改部门或者职位
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改部门或者职位")
	@RequestMapping(value = "/updateSevenMessage", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenMessage(SevenMessage sevenMessage) {
		Map<String, Object> map = new HashMap<>();
		if (sevenMessage.getmType() == null) {
			map.put("status", 3);
			map.put("msg", "类型不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenMessage.getmName())) {
			map.put("status", 3);
			map.put("msg", "名称不能为空");
			return map;
		}
		Boolean result = sevenMessageService.updateSevenMessage(sevenMessage);
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
	 * 查看全部部门 职位
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public Map<String, Object> selectAll() {
		Map<String, Object> map = new HashMap<>();
		List<SevenMessage> branch = sevenMessageService.selectDepart();
		List<SevenMessage> post = sevenMessageService.selectPosition();
		map.put("status", 0);
		map.put("branch", branch);
		map.put("post", post);
		return map;
	}

	/*
	 * 查看部门或者职位
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenMessageById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenMessageById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenMessage sevenMessage = sevenMessageService.selectSevenMessageById(id);
		map.put("status", 0);
		map.put("data", sevenMessage);
		return map;
	}

	/*
	 * 分页查看部门或者职位
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenMessageList", method = RequestMethod.GET)
	public Map<String, Object> getSevenMessageList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String mName, Integer mType) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenMessage> list = sevenMessageService.getSevenMessageList(page, limit, mName, mType);
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
