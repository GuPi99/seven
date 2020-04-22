package com.ally.sevenaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenaccount.mapper.SevenAccountMapper;
import com.ally.sevenrole.mapper.SevenRoleMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenAccountServiceImpl implements SevenAccountService {

	@Autowired
	private SevenAccountMapper sevenAccountMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	@Autowired
	private SevenRoleMapper sevenRoleMapper;

	// 添加
	@Override
	public Boolean addSevenAccount(SevenAccount sevenAccount) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.insert(sevenAccount) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenAccount(Integer id) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.deleteByPrimaryKey(id) > 0;
	}

	// 查询
	@Override
	public SevenAccount selectSevenAccount(Integer id) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.selectByPrimaryKey(id);
	}

	// 修改
	@Override
	public Boolean updateSevenAccount(SevenAccount sevenAccount) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.updateByPrimaryKey(sevenAccount) > 0;
	}

	// 查询全部
	@Override
	public List<SevenAccount> selectAll() {
		// TODO Auto-generated method stub
		return sevenAccountMapper.selectAll();
	}

	//修改状态
	@Override
	public Boolean updateSevenAccountState(Integer id, Integer aState) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.updateSevenAccountState(id,aState) > 0;
	}


	@Override
	public PageInfo<SevenAccount> getSevenAccountList(Integer pageNum, Integer pageSize, String aAccount) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenAccount> list = sevenAccountMapper.getSevenAccountList(aAccount);
		for (SevenAccount sevenAccount : list) {
			sevenAccount.setStaffName(sevenStaffMapper.selectName(sevenAccount.getaSid()));
			sevenAccount.setRoleName(sevenRoleMapper.selectName(sevenAccount.getaRid()));
			if (sevenAccount.getaState() == 0) {
				sevenAccount.setState("启用");
			} else {
				sevenAccount.setState("禁用");
			}
		}
		PageInfo<SevenAccount> info=new PageInfo<>(list,10);
		return info;
	}

	//检车用户名是否存在
	@Override
	public String checkName(String aAccount) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.checkName(aAccount);
	}

	//登录
	@Override
	public SevenAccount login(String aAccount, String md5Pwd) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.login(aAccount,md5Pwd);
	}

	@Override
	public Boolean updateNowSevenAccount(SevenAccount sevenAccount) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.updateNowSevenAccount(sevenAccount) > 0;
	}

	@Override
	public List<SevenAccount> selectOtherAccount(Integer id) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.selectOtherAccount(id);
	}

	@Override
	public Boolean updatePassword(String paws, Integer id) {
		// TODO Auto-generated method stub
		return sevenAccountMapper.updatePassword(paws,id);
	}
}
