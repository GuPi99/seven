package com.ally.sevenprojectschedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenprojectschedule.bean.SevenProjectSchedule;
import com.ally.sevenprojectschedule.mapper.SevenProjectScheduleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenProjectScheduleServiceImpl implements SevenProjectScheduleService {

	@Autowired
	private SevenProjectScheduleMapper sevenProjectScheduleMapper;
	@Override
	public PageInfo<SevenProjectSchedule> getSevenProjectScheduleList(Integer pageNum, Integer pageSize, Integer psPid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenProjectSchedule> list = sevenProjectScheduleMapper.getSevenProjectScheduleList(psPid);
		PageInfo<SevenProjectSchedule> info=new PageInfo<>(list,10);
		return info;
	}
	@Override
	public Boolean addSevenProjectSchedule(SevenProjectSchedule sevenProjectSchedule) {
		// TODO Auto-generated method stub
		return sevenProjectScheduleMapper.insert(sevenProjectSchedule)>0;
	}

}
