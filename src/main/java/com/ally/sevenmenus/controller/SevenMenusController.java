package com.ally.sevenmenus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenmenus.bean.Menus;
import com.ally.sevenmenus.bean.SevenMenus;
import com.ally.sevenmenus.service.SevenMenusService;
import com.ally.sevenrole.bean.SevenRole;
import com.ally.sevenrole.service.SevenRoleService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sevenMenus")
public class SevenMenusController {

	@Autowired
	private SevenMenusService sevenMenusService;
	@Autowired
	private SevenRoleService sevenRoleService;
	
	/*
	 * 跳转到首页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/index/index";
	}
	
	
	/*
	 * 跳转到首页
	 */
	@RequestMapping("/indexShow")
	public String indexShow() {
		return "view/home/index";
	}
	
	/*
	 * 跳转到菜单列表
	 */
	@RequestMapping("/toMenusIndex")
	public String toMenusIndex() {
		return "view/sevenMenus/index";
	}
	
	/*
	 * 跳转到菜单修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenMenus/sevenMenus-update";
	}
	
	/*
	 * 跳转到菜单添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenMenus/sevenMenus-add";
	}
	
	/*
	 * 跳转到类型列表
	 */
	@RequestMapping("/toClassIndex")
	public String toClassIndex() {
		return "view/sevenClass/index";
	}
	
	/*
	 * 跳转到商品列表
	 */
	@RequestMapping("/toGoodsIndex")
	public String toGoodsIndex() {
		return "view/sevenGoods/index";
	}
	
	/*
	 * 跳转到银行列表
	 */
	@RequestMapping("/toBankIndex")
	public String toBankIndex() {
		return "view/sevenBank/index";
	}
	
	/*
	 * 跳转到企业列表
	 */
	@RequestMapping("/toFirmIndex")
	public String toFirmIndex() {
		return "view/sevenFirm/index";
	}
	
	/*
	 * 跳转到日志列表
	 */
	@RequestMapping("/toLogIndex")
	public String toLogIndex() {
		return "view/sevenLog/index";
	}

	/*
	 * 添加菜单
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加菜单")
	@RequestMapping(value = "/addSevenMenus", method = RequestMethod.POST)
	public Map<String, Object> addSevenMenus(SevenMenus sevenMenus) {
		Map<String, Object> map = new HashMap<>();
		sevenMenus.setmState(0);
		Boolean result = sevenMenusService.addSevenMenus(sevenMenus);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
		} else {
			map.put("status", 1);
			map.put("msg", "添加失败");
		}
		return map;
	}

	/*
	 * 删除菜单
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除菜单")
	@RequestMapping(value = "/deleteSevenMenus", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenMenus(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenMenusService.deleteSevenMenus(id);
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
	 * 修改菜单
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改菜单")
	@RequestMapping(value = "/updateSevenMenus", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenMenus(SevenMenus sevenMenus) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenMenusService.updateSevenMenus(sevenMenus);
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
	 * 修改菜单状态
	 * */
	@ResponseBody
	@ArchivesLog(operteContent = "修改菜单状态")
	@RequestMapping(value = "/updateState", method = RequestMethod.GET)
	public Map<String, Object> updateState(Integer id,Integer mState) {
		Map<String, Object> map = new HashMap<>();
		Boolean result = sevenMenusService.updateState(id,mState);
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
	 * 查询个人全部菜单
	 */
	@ResponseBody
	@RequestMapping(value = "/selectMenus", method = RequestMethod.GET)
	public Map<String, Object> selectMenus() {
		Map<String, Object> map = new HashMap<>();
		List<Menus> list = sevenMenusService.selectMenus();
		map.put("status", 0);
		map.put("data", list);
		return map;
	}
	
	
	/*
	 * 查询全部菜单
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public Map<String, Object> selectAll(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SevenAccount sevenAccount = (SevenAccount) session.getAttribute("account");
		Integer getaRid = sevenAccount.getaRid();
		SevenRole accountRole = sevenRoleService.selectSevenRoleById(getaRid);
		String getrPermissions = accountRole.getrPermissions();
		List<SevenMenus> list = sevenMenusService.selectRolePermissions(getrPermissions);
		map.put("status", 0);
		map.put("data", list);
		return map;
	}
	
	

	/*
	 * 查看菜单
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenMenusById", method = RequestMethod.GET)
	public Map<String, Object> selectSevenMenusById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenMenus sevenMenus = sevenMenusService.selectSevenMenusById(id);
		map.put("status", 0);
		map.put("data", sevenMenus);
		return map;
	}
	
	

	/*
	 * 分页查询菜单
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenMenusList", method = RequestMethod.GET)
	public Map<String, Object> getSevenMenusList(@RequestParam(required = true, defaultValue = "1") Integer page,Integer limit,Integer mMid,String mName) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenMenus> list = sevenMenusService.getSevenMenusList(page,limit,mMid,mName);
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
