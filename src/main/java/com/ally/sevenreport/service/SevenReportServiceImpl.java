package com.ally.sevenreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenreport.bean.SevenReport;
import com.ally.sevenreport.mapper.SevenReportMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenReportServiceImpl implements SevenReportService {

	@Autowired
	private SevenReportMapper sevenReportMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;

	// 添加
	@Override
	public Boolean addSevenReport(SevenReport sevenReport) {
		// TODO Auto-generated method stub
		return sevenReportMapper.insert(sevenReport) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenReport(SevenReport sevenReport) {
		// TODO Auto-generated method stub
		return sevenReportMapper.updateByPrimaryKey(sevenReport) > 0;
	}

	@Override
	public PageInfo<SevenReport> getSevenReportList(Integer pageNum, Integer pageSize, Integer rSid, String rDate,
			String rTitle) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenReport> list = sevenReportMapper.getSevenReportList(rSid, "%" + rDate + "%", "%" + rTitle + "%");
		for (SevenReport sevenReport : list) {
			sevenReport.setStaffName(sevenStaffMapper.selectName(sevenReport.getrSid()));
		}
		PageInfo<SevenReport> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public SevenReport selectSevenReport(Integer id) {
		// TODO Auto-generated method stub
		return sevenReportMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean addIndicate(SevenReport sevenReport) {
		// TODO Auto-generated method stub
		return sevenReportMapper.addIndicate(sevenReport) > 0;
	}

	@Override
	public Boolean addReply(SevenReport sevenReport) {
		// TODO Auto-generated method stub
		return sevenReportMapper.addReply(sevenReport) > 0;
	}

}
