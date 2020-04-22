package com.ally.sevenprint.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenprint.bean.SevenPrint;
import com.ally.sevenprint.mapper.SevenPrintMapper;

@Service
public class SevenPrintServiceImpl implements SevenPrintService {

	@Autowired
	private SevenPrintMapper sevenPrintMapper;

	// 添加
	@Override
	public Boolean addSevenPrint(SevenPrint sevenPrint) {
		// TODO Auto-generated method stub
		return sevenPrintMapper.insert(sevenPrint) > 0;
	}

	// 查询
	@Override
	public SevenPrint selectSevenPrint(Integer id) {
		// TODO Auto-generated method stub
		return sevenPrintMapper.selectByPrimaryKey(id);
	}

	// 删除
	@Override
	public Boolean deletesevenPrint(Integer id) {
		// TODO Auto-generated method stub
		return sevenPrintMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenPrint(SevenPrint sevenPrint) {
		// TODO Auto-generated method stub
		return sevenPrintMapper.updateByPrimaryKey(sevenPrint) > 0;
	}

	@Override
	public String selectUrl(Integer getaPid) {
		// TODO Auto-generated method stub
		return sevenPrintMapper.selectUrl(getaPid);
	}



}
