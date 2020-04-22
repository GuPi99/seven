package com.ally.sevenrole.controller;

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

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenaccount.service.SevenAccountService;
import com.ally.sevenmenus.bean.Menus;
import com.ally.sevenmenus.service.SevenMenusService;
import com.ally.sevenrole.bean.SevenRole;
import com.ally.sevenrole.service.SevenRoleService;
import com.ally.sevenstaff.bean.SevenStaff;
import com.ally.sevenstaff.service.SevenStaffService;
import com.ally.util.ArchivesLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("sevenRole")
public class SevenRoleController {

	@Autowired
	private SevenRoleService sevenRoleService;
	@Autowired
	private SevenMenusService sevenMenusService;
	@Autowired
	private SevenStaffService sevenStaffService;
	@Autowired
	private SevenAccountService sevenAccountService;
	
	
	/*
	 * 跳转到列表页
	 */
	@RequestMapping("/index")
	public String index() {
		return "view/sevenRole/index";
	}
	
	/*
	 * 跳转到添加页
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "view/sevenRole/sevenRole-add";
	}
	
	/*
	 * 跳转到修改页
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "view/sevenRole/sevenRole-update";
	}
	
	/*
	 * 添加角色
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "添加角色")
	@RequestMapping(value = "/addSevenRole", method = RequestMethod.POST)
	public Map<String, Object> addSevenRole(SevenRole sevenRole) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenRole.getrName())) {
			map.put("status", 1);
			map.put("msg", "名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenRole.getrPermissions())) {
			map.put("status", 1);
			map.put("msg", "权限不能为空");
			return map;
		}
		Boolean result = sevenRoleService.addSevenRole(sevenRole);
		if (result) {
			map.put("status", 0);
			map.put("msg", "添加成功");
			return map;
		} else {
			map.put("status", 1);
			map.put("msg", "添加失败");
			return map;
		}
	}
	
	/*
	 * 修改角色
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "修改角色")
	@RequestMapping(value = "/updateSevenRole", method = RequestMethod.PUT)
	public Map<String, Object> updateSevenRole(SevenRole sevenRole) {
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isEmpty(sevenRole.getrName())) {
			map.put("status", 1);
			map.put("msg", "名称不能为空");
			return map;
		}
		if (StringUtils.isEmpty(sevenRole.getrPermissions())) {
			map.put("status", 1);
			map.put("msg", "权限不能为空");
			return map;
		}
		Boolean result = sevenRoleService.updateSevenRole(sevenRole);
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
	 * 删除角色
	 */
	@ResponseBody
	@ArchivesLog(operteContent = "删除角色")
	@RequestMapping(value = "/deleteSevenRole", method = RequestMethod.GET)
	public Map<String, Object> deleteSevenRole(Integer id) {
		Map<String, Object> map = new HashMap<>();
		List<SevenAccount> list=sevenAccountService.selectOtherAccount(id);
		if (list.size()!=0) {
			map.put("status", 1);
			map.put("msg", "此角色下有账户,禁止删除");
			return map;
		}else {
			Boolean result = sevenRoleService.deleteSevenRole(id);
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
	 * 查看角色
	 */
	@ResponseBody
	@RequestMapping(value = "/selectSevenRoleById", method = RequestMethod.GET)
	public Map<String, Object>  selectSevenRoleById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		SevenRole sevenRole= sevenRoleService.selectSevenRoleById(id);
		List<Menus> list=sevenMenusService.selectRoleMenus(sevenRole.getrPermissions());
		map.put("status", 0);
		map.put("data", sevenRole);
		map.put("datas", list);
		return map;
	}

	/*
	 * 查询全部角色和未拥有账户的员工
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAllRole", method = RequestMethod.GET)
	public Map<String, Object> selectAllRole() {
		Map<String, Object> map = new HashMap<>();
		List<SevenRole> roles = sevenRoleService.selectAllRole();
		List<SevenStaff> staffs=sevenStaffService.selectNoAccount();
		map.put("status", 0);
		map.put("data", roles);
		map.put("datan", staffs);
		return map;
	}
	
	/*
	 * 查询全部角色和全部员工
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public Map<String, Object> selectAll() {
		Map<String, Object> map = new HashMap<>();
		List<SevenRole> roles = sevenRoleService.selectAllRole();
		List<SevenStaff> staffs=sevenStaffService.selectAll();
		map.put("status", 0);
		map.put("data", roles);
		map.put("datan", staffs);
		return map;
	}
	
	
	/*
	 * 分页查询角色信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getSevenRoleList", method = RequestMethod.GET)
	public Map<String, Object> getSevenRoleList(@RequestParam(required = true, defaultValue = "1") Integer page,Integer limit,String rName) {
		Map<String, Object> map = new HashMap<>();
		PageInfo<SevenRole> list = sevenRoleService.getSevenRoleList(page,limit,rName);
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
