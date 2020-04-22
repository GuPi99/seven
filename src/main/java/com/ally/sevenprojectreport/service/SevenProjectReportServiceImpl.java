package com.ally.sevenprojectreport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenprojectreport.bean.SevenProjectReport;
import com.ally.sevenprojectreport.mapper.SevenProjectReportMapper;

@Service
public class SevenProjectReportServiceImpl implements SevenProjectReportService {

	@Autowired
	private SevenProjectReportMapper sevenProjectReportMapper;
	
	@Override
	public Boolean addSevenProjectReport(SevenProjectReport sevenProjectReport) {
		// TODO Auto-generated method stub
		return sevenProjectReportMapper.insert(sevenProjectReport)>0;
	}

	@Override
	public SevenProjectReport selectProjectReport(Integer prPid) {
		// TODO Auto-generated method stub
		return sevenProjectReportMapper.selectProjectReport(prPid);
	}

}
