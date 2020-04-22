package com.ally.sevenmenus.service;

import java.util.List;

import com.ally.sevenmenus.bean.Menus;
import com.ally.sevenmenus.bean.SevenMenus;
import com.github.pagehelper.PageInfo;

public interface SevenMenusService {

	Boolean addSevenMenus(SevenMenus sevenMenus);

	Boolean deleteSevenMenus(Integer id);

	Boolean updateSevenMenus(SevenMenus sevenMenus);

	List<Menus> selectMenus();

	SevenMenus selectSevenMenusById(Integer id);

	PageInfo<SevenMenus> getSevenMenusList(Integer page, Integer limit, Integer mMid,String mName);

	Boolean updateState(Integer id, Integer mState);

	List<SevenMenus> selectAll();

	List<Menus> selectRoleMenus(String getrPermissions);

	List<SevenMenus> selectRolePermissions(String getrPermissions);

}
