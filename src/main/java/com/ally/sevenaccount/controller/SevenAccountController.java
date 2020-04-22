package com.ally.sevenaccount.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenaccount.bean.Password;
import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenaccount.service.SevenAccountService;
import com.ally.sevenprint.bean.SevenPrint;
import com.ally.sevenprint.service.SevenPrintService;
import com.ally.util.ArchivesLog;
import com.ally.util.MD5Util;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenAccount")
public class SevenAccountController {

	@Autowired
	private SevenAccountService sevenAccountService;
	@Autowired
	private SevenPrintService sevenPrintService;

	/*
	 * 跳转到账户添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenAccount/sevenAccount-add";
	}

	/*
	 * 跳转到个性化中心
	 */
	@RequestMapping("/head")
	public String toHead() {
		return "view/index/head";
	}
	
	/*
	 * 跳转到个性化中心
	 */
	@RequestMapping("/pwd")
	public String toPwd() {
		return "view/index/pwd";
	}

	
	/*
	 * 跳转到账户列表
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenAccount/index";
	}

	/*
	 * 跳转到账户修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenAccount/sevenAccount-update";
	}

	/*
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)
	public Map<String, String> loginCheck(String aAccount, String aPassword, HttpSession session, String code) {
		String loginCode = (String) session.getAttribute("loginCode");
		session.removeAttribute("loginCode");
		Map<String, String> map = new HashMap<>();
		if (!code.equalsIgnoreCase(loginCode)) {
			map.put("status", "code");
			map.put("msg", "验证码错误！");
			return map;
		}
		SevenAccount sevenAccount = sevenAccountService.login(aAccount, MD5Util.getMd5Pwd(MD5Util.getMd5Pwd(aPassword)));
		if (sevenAccount != null) {
			if (sevenAccount.getaState() != -1) {
				session.setMaxInactiveInterval(3600 * 5);
				session.setAttribute("account", sevenAccount);
				map.put("status", "200");
				return map;
			} else {
				map.put("status", "error");
				map.put("msg", "您已被限制登录，请联系管理员");
				return map;
			}
		} else {
			map.put("status", "pwd");
			map.put("msg", "用户名或密码错误！");
			return map;
		}
	}
	
	/*
	 * 查看当前账户信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenAccount", method = RequestMethod.GET)
	public Map<String, Object> selectSevenAccount(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		SevenPrint sevenPrint = sevenPrintService.selectSevenPrint(sevenAccount.getaPid());
		map.put("status", 0);
		map.put("data", sevenAccount);
		if (sevenPrint==null) {
			map.put("datas", "/resource/sevenPrint/head.jpg");
		} else {
			map.put("datas", sevenPrint.getpUrl());
		}
		return map;
	}

	//退出
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }

	/*
	 * 添加账户信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加账户信息")
	@RequestMapping(value = "/addSevenAccount", method = RequestMethod.POST)
	public Map<String, Object> addSevenAccount(SevenAccount sevenAccount) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenAccount.getaAccount())) {
			map.put("status", 3);
			map.put("msg", "账户不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenAccount.getaPassword())) {
			map.put("status", 3);
			map.put("msg", "密码不能为空");
			return map;
		}
		if (sevenAccount.getaRid()==null) {
			map.put("status", 3);
			map.put("msg", "角色不能为空");
			return map;
		}
		if (sevenAccount.getaSid()==null) {
			map.put("status", 3);
			map.put("msg", "使用员工不能为空");
			return map;
		}
		sevenAccount.setaPassword(MD5Util.getMd5Pwd(MD5Util.getMd5Pwd(sevenAccount.getaPassword())));
		sevenAccount.setaState(0);
		sevenAccount.setaNickname("普通用户");
		Boolean result = sevenAccountService.addSevenAccount(sevenAccount);
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
	 * 删除账户信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除账户信息")
	@RequestMapping(value = "/deleteSevenAccount", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenAccount(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenAccountService.deleteSevenAccount(id);
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
	 * 修改账户类型信息
	 */
	@ResponseBody 
	@ArchivesLog(operteContent = "修改账户类型信息")
	@RequestMapping(value = "/updateSevenAccount", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenAccount(SevenAccount sevenAccount) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenAccount.getaAccount())) {
			map.put("status", 3);
			map.put("msg", "账户不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenAccount.getaPassword())) {
			map.put("status", 3);
			map.put("msg", "密码不能为空");
			return map;
		}
		if (sevenAccount.getaRid()==null) {
			map.put("status", 3);
			map.put("msg", "角色不能为空");
			return map;
		}
		if (sevenAccount.getaSid()==null) {
			map.put("status", 3);
			map.put("msg", "使用员工不能为空");
			return map;
		}
		sevenAccount.setaPassword(MD5Util.getMd5Pwd(MD5Util.getMd5Pwd(sevenAccount.getaPassword())));
		sevenAccount.setaState(0);
		Boolean result = sevenAccountService.updateSevenAccount(sevenAccount);
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
	 * 修改当前账户类型信息
	 */
	@ResponseBody 
	@ArchivesLog(operteContent = "修改当前账户信息")
	@RequestMapping(value = "/updateNowSevenAccount", method = RequestMethod.PUT)
	public Map<String, Object> updateNewSevenAccount(SevenAccount sevenAccount,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount now = (SevenAccount) session.getAttribute("account");
		if (sevenAccount.getaPid()==null) {
			sevenAccount.setaPid(now.getaPid());
		}
		sevenAccount.setId(now.getId());
		Boolean result = sevenAccountService.updateNowSevenAccount(sevenAccount);
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
	 * 修改账户状态信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改账户状态信息")
	@RequestMapping(value = "/updateSevenAccountState", method = RequestMethod.GET)
	public Map<String, Object> updateSevenAccountStates(Integer id, Integer aState) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenAccountService.updateSevenAccountState(id, aState);
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
	 * 查看账户信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenAccountById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenAccountById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = sevenAccountService.selectSevenAccount(id);
		map.put("status", 0);
		map.put("data", sevenAccount);
		return map;
	}
	
	

	/*
	 * 分页查询账户信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenAccountList", method = RequestMethod.GET)
	public Map<String, Object> getSevenAccountList(@RequestParam(required = true, defaultValue = "1") Integer page,
			Integer limit, String aAccount) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenAccount> list = sevenAccountService.getSevenAccountList(page, limit, aAccount);
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

	/*
	 * 检测用户名
	 */
	@ResponseBody
	@RequestMapping(value = "/checkName", method = RequestMethod.POST)
	public Map<String, String> checkName(String aAccount) {
		Map<String, String> map = new HashMap<>();
		String result = sevenAccountService.checkName(aAccount);
		if (result != null) {
			map.put("status", "error");
		} else {
			map.put("status", "success");
		}
		return map;
	}
	
	/*
	 * 修改账户密码信息
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改账户密息")
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public Map<String, Object> updatePassword(Password password,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		if (StringUtils.isEmpty(password.getPaw())) {
			map.put("status", 1);
			map.put("msg", "原密码不能为空");
			return map;
		}
		if (StringUtils.isEmpty(password.getPaws())) {
			map.put("status", 1);
			map.put("msg", "新密码不能为空");
			return map;
		}
		if (StringUtils.isEmpty(password.getPawss())) {
			map.put("status", 1);
			map.put("msg", "确认密码不能为空");
			return map;
		}
		if (!MD5Util.getMd5Pwd(MD5Util.getMd5Pwd(password.getPaw())).equals(sevenAccount.getaPassword())) {
			map.put("status", 1);
			map.put("msg", "原密码输入错误");
			return map;
		}
		if (!password.getPaws().equals(password.getPawss())) {
			map.put("status", 1);
			map.put("msg", "新密码和确认密码不相同");
			return map;
		}
		Boolean result = sevenAccountService.updatePassword(MD5Util.getMd5Pwd(MD5Util.getMd5Pwd(password.getPaws())),sevenAccount.getId());
		if (result) {
			map.put("status", 0);
			map.put("msg", "修改成功,请重新登录!");
			return map;
		} else {
			map.put("status", 1);
			map.put("msg", "修改失败");
			return map;
		}
	}
	
}
