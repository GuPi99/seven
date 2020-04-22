package com.ally.seventripreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.seventripreport.bean.SevenTripReport;
import com.ally.seventripreport.mapper.SevenTripReportMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenTripReportServiceImpl implements SevenTripReportService {

	@Autowired
	private SevenTripReportMapper sevenTripReportMapper;
	
	@Override
	public Boolean addSevenTripReport(SevenTripReport sevenTripReport) {
		// TODO Auto-generated method stub
		return sevenTripReportMapper.insert(sevenTripReport)>0;
	}

	@Override
	public PageInfo<SevenTripReport> getSevenTripReportList(Integer pageNum, Integer pageSize, Integer trEid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenTripReport> list = sevenTripReportMapper.getSevenTripReportList(trEid);
		PageInfo<SevenTripReport> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public SevenTripReport selectTripReport(Integer trEid) {
		// TODO Auto-generated method stub
		return sevenTripReportMapper.selectTripReport(trEid);
	}

}
