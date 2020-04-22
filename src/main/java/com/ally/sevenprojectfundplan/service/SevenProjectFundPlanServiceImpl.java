package com.ally.sevenprojectfundplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenprojectfundplan.bean.SevenProjectFundPlan;
import com.ally.sevenprojectfundplan.mapper.SevenProjectFundPlanMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenProjectFundPlanServiceImpl implements SevenProjectFundPlanService {

	@Autowired
	private SevenProjectFundPlanMapper sevenProjectFundPlanMapper;

	@Override
	public Boolean addSevenProjectFundPlan(SevenProjectFundPlan sevenProjectFundPlan) {
		// TODO Auto-generated method stub
		return sevenProjectFundPlanMapper.insert(sevenProjectFundPlan)>0;
	}

	@Override
	public Boolean updateSevenProjectFundPlan(SevenProjectFundPlan sevenProjectFundPlan) {
		// TODO Auto-generated method stub
		return sevenProjectFundPlanMapper.updateSevenProjectFundPlan(sevenProjectFundPlan)>0;
	}

	@Override
	public PageInfo<SevenProjectFundPlan> getSevenProjectFundPlanList(Integer pageNum, Integer pageSize, Integer pfpPid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenProjectFundPlan> list = sevenProjectFundPlanMapper.getSevenProjectFundPlanList(pfpPid);
		PageInfo<SevenProjectFundPlan> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public SevenProjectFundPlan selectSevenProjectFundPlan(Integer id) {
		// TODO Auto-generated method stub
		return sevenProjectFundPlanMapper.selectSevenProjectFundPlan(id);
	}
}
