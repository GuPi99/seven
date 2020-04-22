package com.ally.sevendailyplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevendailyplan.bean.SevenDailyPlan;
import com.ally.sevendailyplan.mapper.SevenDailyPlanMapper;
import com.ally.sevenevection.mapper.SevenEvectionMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenDailyPlanServiceImpl implements SevenDailyPlanService {

	@Autowired
	private SevenDailyPlanMapper sevenDailyPlanMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	@Autowired
	private SevenEvectionMapper sevenEvectionMapper;

	// 添加
	@Override
	public Boolean addSevenDailyPlan(SevenDailyPlan sevenDailyPlan) {
		// TODO Auto-generated method stub
		return sevenDailyPlanMapper.insert(sevenDailyPlan) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenDailyPlan(Integer id) {
		// TODO Auto-generated method stub
		return sevenDailyPlanMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenDailyPlan(SevenDailyPlan sevenDailyPlan) {
		// TODO Auto-generated method stub
		return sevenDailyPlanMapper.updateByPrimaryKey(sevenDailyPlan) > 0;
	}

	// 查询
	@Override
	public SevenDailyPlan selectSevenDailyPlanById(Integer id) {
		// TODO Auto-generated method stub
		return sevenDailyPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenDailyPlan> getSevenDailyPlanList(Integer pageNum, Integer pageSize, Integer dpSid, Integer dpType,
			String dpDate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenDailyPlan> list = sevenDailyPlanMapper.getSevenDailyPlanList(dpSid,dpType,"%"+dpDate+"%");
		for (SevenDailyPlan sevenDailyPlan : list) {
			if (sevenDailyPlan.getDpWhere()!=1) {
				sevenDailyPlan.setSevenEvection(sevenEvectionMapper.selectByPrimaryKey(sevenDailyPlan.getDpEid()));
			} 
			sevenDailyPlan.setStaffName(sevenStaffMapper.selectName(sevenDailyPlan.getDpSid()));
		}
		PageInfo<SevenDailyPlan> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public PageInfo<SevenDailyPlan> getSelfDayList(Integer pageNum, Integer pageSize, Integer getaSid, Integer dpWhere,
			String dpDate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenDailyPlan> list = sevenDailyPlanMapper.getSelfDayList(getaSid,dpWhere,"%"+dpDate+"%");
		for (SevenDailyPlan sevenDailyPlan : list) {
			if (sevenDailyPlan.getDpWhere()!=1) {
				sevenDailyPlan.setSevenEvection(sevenEvectionMapper.selectByPrimaryKey(sevenDailyPlan.getDpEid()));
			} 
			sevenDailyPlan.setStaffName(sevenStaffMapper.selectName(sevenDailyPlan.getDpSid()));
		}
		PageInfo<SevenDailyPlan> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public PageInfo<SevenDailyPlan> getSelfWeekList(Integer pageNum, Integer pageSize, Integer getaSid, Integer dpWhere,
			String dpDate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenDailyPlan> list = sevenDailyPlanMapper.getSelfWeekList(getaSid,dpWhere,"%"+dpDate+"%");
		for (SevenDailyPlan sevenDailyPlan : list) {
			sevenDailyPlan.setStaffName(sevenStaffMapper.selectName(sevenDailyPlan.getDpSid()));
		}
		PageInfo<SevenDailyPlan> info = new PageInfo<>(list, 10);
		return info;
	}

}
