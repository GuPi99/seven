package com.ally.sevengoods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenclass.mapper.SevenClassMapper;
import com.ally.sevengoods.bean.SevenGoods;
import com.ally.sevengoods.mapper.SevenGoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenGoodsServiceImpl implements SevenGoodsService {

	@Autowired
	private SevenGoodsMapper sevenGoodsMapper;
	@Autowired
	private SevenClassMapper sevenClassMapper;

	// 添加
	@Override
	public Boolean addSevenGoods(SevenGoods sevenGoods) {
		// TODO Auto-generated method stub
		return sevenGoodsMapper.insert(sevenGoods) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenGoods(Integer id) {
		// TODO Auto-generated method stub
		return sevenGoodsMapper.deleteByPrimaryKey(id) > 0;
	}

	// 查询品名
	@Override
	public SevenGoods selectSevenGoods(Integer id) {
		// TODO Auto-generated method stub
		return sevenGoodsMapper.selectByPrimaryKey(id);
	}

	// 修改品名信息
	@Override
	public Boolean updateSevenGoods(SevenGoods sevenGoods) {
		// TODO Auto-generated method stub
		return sevenGoodsMapper.updateByPrimaryKey(sevenGoods) > 0;
	}

	@Override
	public PageInfo<SevenGoods> getSevenGoodsList(Integer pageNum, Integer pageSize, Integer gCid, String gName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenGoods> list = sevenGoodsMapper.getSevenGoodsList(gCid,"%"+gName+"%");
		for (SevenGoods sevenGoods : list) {
			sevenGoods.setcName(sevenClassMapper.selectByPrimaryKey(sevenGoods.getgCid()).getcName());
			if (sevenGoods.getgGid()==0) {
				sevenGoods.setOnName("无");
			} else {
				sevenGoods.setOnName(sevenGoodsMapper.selectByPrimaryKey(sevenGoods.getgGid()).getgName());
			}
		}
		PageInfo<SevenGoods> info=new PageInfo<>(list,10);
		return info;
	}

	//查询全部产品
	@Override
	public List<SevenGoods> selectAll() {
		// TODO Auto-generated method stub
		return sevenGoodsMapper.selectAll();
	}

	//查询列表全部产品名称
	@Override
	public List<SevenGoods> selectAllName() {
		// TODO Auto-generated method stub
		return sevenGoodsMapper.selectAllName();
	}

	//批量添加
	@Override
	public Boolean batchAddition(List<SevenGoods> list) {
		// TODO Auto-generated method stub
		Integer len=sevenGoodsMapper.batchAddition(list);
		return len==list.size();
	}

	@Override
	public List<SevenGoods> selectUnder(Integer id) {
		// TODO Auto-generated method stub
		return sevenGoodsMapper.selectUnder(id);
	}


	@Override
	public List<SevenGoods> selectGoods(Integer id) {
		// TODO Auto-generated method stub
		List<SevenGoods> list = sevenGoodsMapper.selectGoods(id);
		return list;
	}

	@Override
	public PageInfo<SevenGoods> getProjectGoodsList(Integer pageNum, Integer pageSize, Integer id) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenGoods> list = sevenGoodsMapper.selectGoods(id);
		for (SevenGoods sevenGoods : list) {
			sevenGoods.setcName(sevenClassMapper.selectByPrimaryKey(sevenGoods.getgCid()).getcName());
		}
		PageInfo<SevenGoods> info=new PageInfo<>(list,10);
		return info;
	}


}
