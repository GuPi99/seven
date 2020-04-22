package com.ally.sevenmenus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenmenus.bean.Menus;
import com.ally.sevenmenus.bean.SevenMenus;
import com.ally.sevenmenus.mapper.SevenMenusMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenMenusServiceImpl implements SevenMenusService {

	@Autowired
	private SevenMenusMapper sevenMenusMapper;

	// 添加
	@Override
	public Boolean addSevenMenus(SevenMenus sevenMenus) {
		// TODO Auto-generated method stub
		return sevenMenusMapper.insert(sevenMenus) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenMenus(Integer id) {
		// TODO Auto-generated method stub
		return sevenMenusMapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public Boolean updateSevenMenus(SevenMenus sevenMenus) {
		// TODO Auto-generated method stub
		return sevenMenusMapper.updateByPrimaryKey(sevenMenus) > 0;
	}

	// 查询全部
	@Override
	public List<Menus> selectMenus() {
		// TODO Auto-generated method stub
		List<Menus> returnList = new ArrayList<Menus>();
		// 一级菜单
		List<SevenMenus> list = sevenMenusMapper.selectMenus(0);
		for (SevenMenus sevenMenus : list) {
			// 二级菜单
			List<SevenMenus> two = sevenMenusMapper.selectMenus(sevenMenus.getId());
			if (two.size() == 0) {
				if (sevenMenus.getmName().equals("首页")) {
					Menus menus = new Menus();
					menus.setId(sevenMenus.getId());
					menus.setTitle(sevenMenus.getmName());
					menus.setChecked("true");
					returnList.add(menus);
				} else {
					Menus menus = new Menus();
					menus.setId(sevenMenus.getId());
					menus.setTitle(sevenMenus.getmName());
					returnList.add(menus);
				}
			} else {
				List<Menus> three = new ArrayList<>();
				for (SevenMenus sevenMenus2 : two) {
					Menus menus = new Menus();
					menus.setId(sevenMenus2.getId());
					menus.setTitle(sevenMenus2.getmName());
					three.add(menus);
				}
				Menus menus = new Menus();
				menus.setId(sevenMenus.getId());
				menus.setTitle(sevenMenus.getmName());
				menus.setChildren(three);
				returnList.add(menus);
			}
		}
		return returnList;
	}

	@Override
	public SevenMenus selectSevenMenusById(Integer id) {
		// TODO Auto-generated method stub
		return sevenMenusMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenMenus> getSevenMenusList(Integer pageNum, Integer pageSize, Integer mMid, String mName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenMenus> list = sevenMenusMapper.getSevenMenusList(mMid, "%" + mName + "%");
		for (SevenMenus sevenMenus : list) {
			if (sevenMenus.getmState() == 0) {
				sevenMenus.setState("启用");
			} else {
				sevenMenus.setState("禁用");
			}
		}
		PageInfo<SevenMenus> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public Boolean updateState(Integer id, Integer mState) {
		// TODO Auto-generated method stub
		return sevenMenusMapper.updateState(id, mState) > 0;
	}

	@Override
	public List<SevenMenus> selectAll() {
		// TODO Auto-generated method stub
		return sevenMenusMapper.selectAll();
	}

	@Override
	public List<Menus> selectRoleMenus(String getrPermissions) {
		// TODO Auto-generated method stub
		String[] split = getrPermissions.split(",");
		List<Menus> returnList = new ArrayList<Menus>();
		// 一级菜单
		List<SevenMenus> list = sevenMenusMapper.selectMenus(0);
		for (SevenMenus sevenMenus : list) {
			// 二级菜单
			List<SevenMenus> two = sevenMenusMapper.selectMenus(sevenMenus.getId());
			if (two.size() == 0) {
				if (sevenMenus.getmName().equals("首页")) {
					Menus menus = new Menus();
					menus.setId(sevenMenus.getId());
					menus.setTitle(sevenMenus.getmName());
					menus.setChecked("true");
					returnList.add(menus);
				} else {
					if (getrPermissions != null && Arrays.asList(split).contains(sevenMenus.getId() + "")) {
						Menus menus = new Menus();
						menus.setId(sevenMenus.getId());
						menus.setTitle(sevenMenus.getmName());
						menus.setChecked("true");
						returnList.add(menus);
					} else {
						Menus menus = new Menus();
						menus.setId(sevenMenus.getId());
						menus.setTitle(sevenMenus.getmName());
						returnList.add(menus);
					}
				}
			} else {
				List<Menus> three = new ArrayList<>();
				for (SevenMenus sevenMenus2 : two) {
					if (getrPermissions != null && Arrays.asList(split).contains(sevenMenus2.getId() + "")) {
						Menus menus = new Menus();
						menus.setId(sevenMenus2.getId());
						menus.setTitle(sevenMenus2.getmName());
						menus.setChecked("true");
						three.add(menus);
					} else {
						Menus menus = new Menus();
						menus.setId(sevenMenus2.getId());
						menus.setTitle(sevenMenus2.getmName());
						three.add(menus);
					}
				}
				Menus menus = new Menus();
				menus.setId(sevenMenus.getId());
				menus.setTitle(sevenMenus.getmName());
				menus.setChildren(three);
				returnList.add(menus);
			}
		}
		return returnList;
	}

	@Override
	public List<SevenMenus> selectRolePermissions(String getrPermissions) {
		// TODO Auto-generated method stub
		String[] split = getrPermissions.split(",");
		List<SevenMenus> selectRolePermissions = sevenMenusMapper.selectRolePermissions(split);
		return selectRolePermissions;
	}


}
