package com.ally.sevenrole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenrole.bean.SevenRole;
import com.ally.sevenrole.mapper.SevenRoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenRoleServiceImpl implements SevenRoleService {

	@Autowired
	private SevenRoleMapper sevenRoleMapper;
	
	@Override
	public PageInfo<SevenRole> getSevenRoleList(Integer pageNum, Integer pageSize, String rName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenRole> list = sevenRoleMapper.getSevenRoleList("%"+rName+"%");
		PageInfo<SevenRole> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public Boolean addSevenRole(SevenRole sevenRole) {
		// TODO Auto-generated method stub
		return sevenRoleMapper.insert(sevenRole)>0;
	}

	@Override
	public SevenRole selectSevenRoleById(Integer id) {
		// TODO Auto-generated method stub
		return sevenRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean deleteSevenRole(Integer id) {
		// TODO Auto-generated method stub
		return sevenRoleMapper.deleteByPrimaryKey(id)>0;
	}

	@Override
	public Boolean updateSevenRole(SevenRole sevenRole) {
		// TODO Auto-generated method stub
		return sevenRoleMapper.updateByPrimaryKey(sevenRole)>0;
	}

	@Override
	public List<SevenRole> selectAllRole() {
		// TODO Auto-generated method stub
		return sevenRoleMapper.selectAll();
	}

}
