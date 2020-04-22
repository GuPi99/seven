package com.ally.sevenplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenfirm.mapper.SevenFirmMapper;
import com.ally.sevenplan.bean.SevenPlan;
import com.ally.sevenplan.mapper.SevenPlanMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenPlanServiceImpl implements SevenPlanService {

	@Autowired
	private SevenPlanMapper sevenPlanMapper;
	@Autowired
	private SevenFirmMapper sevenFirmMapper;
	
	@Override
	public Boolean addSevenPlan(SevenPlan sevenPlan) {
		// TODO Auto-generated method stub
		return sevenPlanMapper.insert(sevenPlan)>0;
	}

	@Override
	public Boolean deleteSevenPlan(Integer id) {
		// TODO Auto-generated method stub
		return sevenPlanMapper.deleteByPrimaryKey(id)>0;
	}


	@Override
	public PageInfo<SevenPlan> getSevenPlanList(Integer pageNum, Integer pageSize, Integer pEid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenPlan> list = sevenPlanMapper.getSevenPlanList(pEid);
		for (SevenPlan sevenPlan : list) {
			sevenPlan.setFirmName(sevenFirmMapper.selectName(sevenPlan.getpFid()));
			if (sevenPlan.getpIs()==0) {
				sevenPlan.setIsState("上午");
			} else {
				sevenPlan.setIsState("下午");
			}
		}
		PageInfo<SevenPlan> info = new PageInfo<>(list, 10);
		return info;
	}

}
