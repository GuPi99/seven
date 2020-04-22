package com.ally.sevenbank.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenbank.bean.SevenBank;
import com.ally.sevenbank.service.SevenBankService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenBank")
public class SevenBankController {

	@Autowired
	private SevenBankService sevenBankService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenBank/sevenBank-add";
	}

	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenBank/sevenBank-update";
	}

	/*
	 * 添加银行
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加银行")
	@RequestMapping(value = "/addSevenBank", method = RequestMethod.POST)
	public Map<String, Object> addSevenBank(SevenBank sevenBank) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenBank.getbName())) {
			map.put("status", 3);
			map.put("msg", "银行名称不能为空");
			return map;
		}
		Boolean result = sevenBankService.addSevenBank(sevenBank);
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
	 * 删除银行
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除银行")
	@RequestMapping(value = "/deleteSevenBank", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenBank(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenBankService.deleteSevenBank(id);
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
	 * 修改银行信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改银行信息")
	@RequestMapping(value = "/updateSevenBank", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenBank(SevenBank sevenBank) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenBankService.updateSevenBank(sevenBank);
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
	 * 查看银行信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenBankById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenBankById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenBank sevenBank = sevenBankService.selectSevenBank(id);
		map.put("status", 0);
		map.put("data", sevenBank);
		return map;
	}

	/*
	 * 分页查询银行信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenBankList", method = RequestMethod.GET)
	public Map<String, Object> getSevenBankList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String bName) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenBank> list = sevenBankService.getSevenBankList(page, limit, bName);
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
