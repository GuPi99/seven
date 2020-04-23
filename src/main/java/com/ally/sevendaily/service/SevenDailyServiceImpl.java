package com.ally.sevendaily.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevendaily.bean.SevenDaily;
import com.ally.sevendaily.mapper.SevenDailyMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenDailyServiceImpl implements SevenDailyService {

	@Autowired
	private SevenDailyMapper sevenDailyMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	
	// 添加
	@Override
	public Boolean addSvenDaily(SevenDaily sevenDaily) {
		// TODO Auto-generated method stub
		return sevenDailyMapper.insert(sevenDaily) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenDaily(Integer id) {
		// TODO Auto-generated method stub
		return sevenDailyMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenDaily(SevenDaily sevenDaily) {
		// TODO Auto-generated method stub
		return sevenDailyMapper.updateByPrimaryKey(sevenDaily) > 0;
	}

	@Override
	public SevenDaily selectSevenDailyById(Integer id) {
		// TODO Auto-generated method stub
		return sevenDailyMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenDaily> getTrendList(Integer pageNum, Integer pageSize, Integer oSid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenDaily> list = sevenDailyMapper.getTrendList(oSid);
		PageInfo<SevenDaily> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public PageInfo<SevenDaily> getDayDailyList(Integer pageNum, Integer pageSize, Integer dSid, String dDate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenDaily> list = sevenDailyMapper.getSevenDailyList(dSid,"%"+dDate+"%");
		for (SevenDaily sevenDaily : list) {
			sevenDaily.setStaffName(sevenStaffMapper.selectName(sevenDaily.getdSid()));
		}
		PageInfo<SevenDaily> info = new PageInfo<>(list, 10);
		return info;
	}


}
