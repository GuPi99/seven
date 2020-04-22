package com.ally.sevenbankaccount.controller;

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

import com.ally.sevenbank.bean.SevenBank;
import com.ally.sevenbank.service.SevenBankService;
import com.ally.sevenbankaccount.bean.SevenBankAccount;
import com.ally.sevenbankaccount.service.SevenBankAccountService;
import com.ally.sevenfirm.bean.SevenFirm;
import com.ally.sevenfirm.service.SevenFirmService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenBankAccount")
public class SevenBankAccountController {

	@Autowired
	private SevenBankAccountService sevenBankAccountService;
	@Autowired
	private SevenFirmService sevenFirmService;
	@Autowired
	private SevenBankService sevenBankService;

	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenBankAccount/sevenBankAccount-add";
	}

	/*
	 * 跳转到列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenBankAccount/index";
	}

	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenBankAccount/sevenBankAccount-update";
	}

	/*
	 * 添加银行账户信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加银行账户信息")
	@RequestMapping(value = "/addSevenBankAccount", method = RequestMethod.POST)
	public Map<String, Object> addSevenBankAccount(SevenBankAccount sevenBankAccount) {
		Map<String, Object> map = new HashMap<>();
		if (sevenBankAccount.getBaFid() == null) {
			map.put("status", 3);
			map.put("msg", "所属企业不能为空");
			return map;
		}
		if (sevenBankAccount.getBaBid() == null) {
			map.put("status", 3);
			map.put("msg", "银行不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenBankAccount.getBaAccount())) {
			map.put("status", 3);
			map.put("msg", "账户不能为空");
			return map;
		}
		Boolean result = sevenBankAccountService.addSevenBankAccount(sevenBankAccount);
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
	 * 删除银行账户信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除银行账户信息")
	@RequestMapping(value = "/deleteSevenBankAccount", method = RequestMethod.POST)
	public Map<String, Object> deleteSevenBankAccount(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenBankAccountService.deleteSevenBankAccount(id);
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
	 * 修改银行账户信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改银行账户信息")
	@RequestMapping(value = "/updateSevenBankAccount", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenBankAccount(SevenBankAccount sevenBankAccount) {
		Map<String, Object> map = new HashMap<>();
		if (sevenBankAccount.getBaFid() == null) {
			map.put("status", 3);
			map.put("msg", "所属企业不能为空");
			return map;
		}
		if (sevenBankAccount.getBaBid() == null) {
			map.put("status", 3);
			map.put("msg", "银行不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenBankAccount.getBaAccount())) {
			map.put("status", 3);
			map.put("msg", "账户不能为空");
			return map;
		}
		Boolean result = sevenBankAccountService.updateSevenBankAccount(sevenBankAccount);
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
	 * 查看银行账户信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenBankAccountById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenBankAccountById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenBankAccount sevenBankAccount = sevenBankAccountService.selectSevenBankAccountById(id);
		map.put("status", 0);
		map.put("data", sevenBankAccount);
		return map;
	}

	/*
	 * 查询全部企业和银行
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAllBankAndFirm", method = RequestMethod.GET)
	public Map<String, Object> selectAllBankAndFirm() {
		Map<String, Object> map = new HashMap<>();
		List<SevenBank> banks = sevenBankService.seltceAll();
		List<SevenFirm> firms = sevenFirmService.selectAll();
		map.put("status", 0);
		map.put("firm", firms);
		map.put("bank", banks);
		return map;
	}

	/*
	 * 分页银行账户信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenBankAccountList", method = RequestMethod.GET)
	public Map<String, Object> getSevenBankAccountList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, Integer baFid, Integer baBid) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenBankAccount> list = sevenBankAccountService.getSevenBankAccountList(page, limit, baFid, baBid);
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
