package com.ally.sevenprojectgoods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenclass.mapper.SevenClassMapper;
import com.ally.sevengoods.mapper.SevenGoodsMapper;
import com.ally.sevenprojectgoods.bean.SevenProjectGoods;
import com.ally.sevenprojectgoods.mapper.SevenProjectGoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenProjectGoodsServiceImpl implements SevenProjectGoodsService {

	@Autowired
	private SevenProjectGoodsMapper sevenProjectGoodsMapper;
	@Autowired
	private SevenClassMapper sevenClassMapper;
	@Autowired
	private SevenGoodsMapper sevenGoodsMapper;

	// 添加
	@Override
	public Boolean addSevenProjectGoods(SevenProjectGoods sevenProjectGoods) {
		// TODO Auto-generated method stub
		return sevenProjectGoodsMapper.insert(sevenProjectGoods) > 0;
	}

	@Override
	public Boolean delectProjectGoods(Integer id) {
		// TODO Auto-generated method stub
		return sevenProjectGoodsMapper.deleteByPrimaryKey(id)>0;
	}

	@Override
	public PageInfo<SevenProjectGoods> getSevenProjectGoodsList(Integer pageNum, Integer pageSize, Integer pgPid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenProjectGoods> list = sevenProjectGoodsMapper.getSevenProjectGoodsList(pgPid);
		for (SevenProjectGoods sevenProjectGoods : list) {
			sevenProjectGoods.setClassName(sevenClassMapper.selectName(sevenProjectGoods.getPgCid()));
			sevenProjectGoods.setGoodsName(sevenGoodsMapper.selectByPrimaryKey(sevenProjectGoods.getPgGid()).getgName());
			sevenProjectGoods.setGoodsModel(sevenGoodsMapper.selectByPrimaryKey(sevenProjectGoods.getPgGid()).getgModel());
		}
		PageInfo<SevenProjectGoods> info=new PageInfo<>(list,10);
		return info;
	}




}
