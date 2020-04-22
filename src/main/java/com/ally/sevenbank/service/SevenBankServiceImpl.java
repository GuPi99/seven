package com.ally.sevenbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenbank.bean.SevenBank;
import com.ally.sevenbank.mapper.SevenBankMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenBankServiceImpl implements SevenBankService {

	@Autowired
	private SevenBankMapper sevenBankMapper;

	// 添加
	@Override
	public Boolean addSevenBank(SevenBank sevenBank) {
		// TODO Auto-generated method stub
		return sevenBankMapper.insert(sevenBank) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenBank(Integer id) {
		// TODO Auto-generated method stub
		return sevenBankMapper.deleteByPrimaryKey(id) > 0;
	}

	// 查询单个银行
	@Override
	public SevenBank selectSevenBank(Integer id) {
		// TODO Auto-generated method stub
		return sevenBankMapper.selectByPrimaryKey(id);
	}

	// 修改
	@Override
	public Boolean updateSevenBank(SevenBank sevenBank) {
		// TODO Auto-generated method stub
		return sevenBankMapper.updateByPrimaryKey(sevenBank) > 0;
	}

	@Override
	public PageInfo<SevenBank> getSevenBankList(Integer pageNum, Integer pageSize,String bName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenBank> list = sevenBankMapper.getSevenBankList(bName);
		PageInfo<SevenBank> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public List<SevenBank> seltceAll() {
		// TODO Auto-generated method stub
		return sevenBankMapper.selectAll();
	}

	

}
