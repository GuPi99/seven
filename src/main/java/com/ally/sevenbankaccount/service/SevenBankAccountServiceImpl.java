package com.ally.sevenbankaccount.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenbank.mapper.SevenBankMapper;
import com.ally.sevenbankaccount.bean.SevenBankAccount;
import com.ally.sevenbankaccount.mapper.SevenBankAccountMapper;
import com.ally.sevenfirm.mapper.SevenFirmMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenBankAccountServiceImpl implements SevenBankAccountService {

	@Autowired
	private SevenBankAccountMapper sevenBankAccountMapper;
	@Autowired
	private SevenBankMapper sevenBankMapper;
	@Autowired
	private SevenFirmMapper sevenFirmMapper;

	// 添加
	@Override
	public Boolean addSevenBankAccount(SevenBankAccount sevenBankAccount) {
		// TODO Auto-generated method stub
		return sevenBankAccountMapper.insert(sevenBankAccount) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenBankAccount(Integer id) {
		// TODO Auto-generated method stub
		return sevenBankAccountMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenBankAccount(SevenBankAccount sevenBankAccount) {
		// TODO Auto-generated method stub
		return sevenBankAccountMapper.updateByPrimaryKey(sevenBankAccount) > 0;
	}

	// 查询
	@Override
	public SevenBankAccount selectSevenBankAccountById(Integer id) {
		// TODO Auto-generated method stub
		return sevenBankAccountMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenBankAccount> getSevenBankAccountList(Integer pageNum, Integer pageSize, Integer baFid,
			Integer baBid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenBankAccount> list = sevenBankAccountMapper.getSevenBankAccountList(baFid,baBid);
		for (SevenBankAccount sevenBankAccount : list) {
			sevenBankAccount.setFirmName(sevenFirmMapper.selectName(sevenBankAccount.getBaFid()));
			sevenBankAccount.setBankName(sevenBankMapper.selectByPrimaryKey(sevenBankAccount.getBaBid()).getbName());
		}
		PageInfo<SevenBankAccount> info=new PageInfo<>(list,10);
		return info;
	}

	//查询全部
	@Override
	public List<SevenBankAccount> seltceAll() {
		// TODO Auto-generated method stub
		return sevenBankAccountMapper.selectAll();
	}


}
