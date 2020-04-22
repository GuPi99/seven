package com.ally.sevencensus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevencensus.bean.SevenCensus;
import com.ally.sevencensus.mapper.SevenCensusMapper;
import com.ally.sevengoods.mapper.SevenGoodsMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenCensusServiceImpl implements SevenCensusService {

	@Autowired
	private SevenCensusMapper sevenCensusMapper;
	@Autowired
	private SevenGoodsMapper sevenGoodsMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;

	@Override
	public Boolean addSevenCensus(SevenCensus sevenCensus) {
		// TODO Auto-generated method stub
		return sevenCensusMapper.insert(sevenCensus)>0;
	}

	@Override
	public PageInfo<SevenCensus> getSevenCensusList(Integer pageNum, Integer pageSize, Integer productId, String censusDate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenCensus> list = sevenCensusMapper.getSevenCensusList(productId,"%"+censusDate+"%");
		for (SevenCensus sevenCensus : list) {
			sevenCensus.setProductName(sevenGoodsMapper.selectName(sevenCensus.getProductId()));
			sevenCensus.setCensusName(sevenStaffMapper.selectName(sevenCensus.getStaffId()));
		}
		PageInfo<SevenCensus> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public List<SevenCensus> getCensusNumber(String censusDate) {
		// TODO Auto-generated method stub
		List<SevenCensus> newList=new ArrayList<SevenCensus>();
		List<SevenCensus> oldList=sevenCensusMapper.getCensusNumber("%"+censusDate+"%");
		for (SevenCensus oldSevenCensus : oldList) {
			boolean flag=true;
			for (SevenCensus newSevenCensus : newList) {
				if (newSevenCensus.getProductId()==oldSevenCensus.getProductId()) {
					newSevenCensus.setSaleVolume(newSevenCensus.getSaleVolume().add(oldSevenCensus.getSaleVolume()));
					flag=false;
				}
			}
			if (flag) {
				newList.add(oldSevenCensus);
			}
		}
		for (SevenCensus sevenCensus : newList) {
			sevenCensus.setProductName(sevenGoodsMapper.selectName(sevenCensus.getProductId()));
		}
		System.out.println(newList);
		return newList;
	}

	@Override
	public List<SevenCensus> getCensusMoney(String censusDate) {
		// TODO Auto-generated method stub
		List<SevenCensus> newList=new ArrayList<SevenCensus>();
		List<SevenCensus> oldList=sevenCensusMapper.getCensusMoney("%"+censusDate+"%");
		for (SevenCensus oldSevenCensus : oldList) {
			boolean flag=true;
			for (SevenCensus newSevenCensus : newList) {
				if (newSevenCensus.getcSid()==oldSevenCensus.getcSid()) {
					newSevenCensus.setMonthMoney(newSevenCensus.getMonthMoney().add(oldSevenCensus.getMonthMoney()));
					flag=false;
				}
			}
			if (flag) {
				newList.add(oldSevenCensus);
			}
		}
		for (SevenCensus sevenCensus : newList) {
			sevenCensus.setStaffName(sevenStaffMapper.selectName(sevenCensus.getcSid()));
		}
		return newList;
	}

}
