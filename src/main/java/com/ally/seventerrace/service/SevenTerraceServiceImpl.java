package com.ally.seventerrace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenfirm.mapper.SevenFirmMapper;
import com.ally.seventerrace.bean.SevenTerrace;
import com.ally.seventerrace.mapper.SevenTerraceMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenTerraceServiceImpl implements SevenTerraceService {

	@Autowired
	private SevenTerraceMapper sevenTerraceMapper;
	@Autowired
	private SevenFirmMapper sevenFirmMapper;
	
	//添加
	@Override
	public Boolean addSevenTerrace(SevenTerrace sevenTerrace) {
		// TODO Auto-generated method stub
		return sevenTerraceMapper.insert(sevenTerrace)>0;
	}

	//删除
	@Override
	public Boolean deleteSevenTerrace(Integer id) {
		// TODO Auto-generated method stub
		return sevenTerraceMapper.deleteByPrimaryKey(id)>0;
	}

	//删除
	@Override
	public Boolean updateSevenTerrace(SevenTerrace sevenTerrace) {
		// TODO Auto-generated method stub
		return sevenTerraceMapper.updateByPrimaryKey(sevenTerrace)>0;
	}

	@Override
	public SevenTerrace selectSevenTerraceById(Integer id) {
		// TODO Auto-generated method stub
		return sevenTerraceMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenTerrace> getSevenTerraceList(Integer pageNum, Integer pageSize, Integer tFid, String tName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenTerrace> list = sevenTerraceMapper.getSevenTerraceList(tFid,"%"+tName+"%");
		for (SevenTerrace sevenTerrace : list) {
			sevenTerrace.setFirmName(sevenFirmMapper.selectName(sevenTerrace.gettFid()));
		}
		PageInfo<SevenTerrace> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public Boolean changeState(Integer id, Integer tState) {
		// TODO Auto-generated method stub
		return sevenTerraceMapper.changeState(id,tState)>0;
	}

}
