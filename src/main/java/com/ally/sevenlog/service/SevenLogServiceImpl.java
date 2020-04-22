package com.ally.sevenlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenaccount.bean.SevenAccount;
import com.ally.sevenaccount.mapper.SevenAccountMapper;
import com.ally.sevenlog.bean.SevenLog;
import com.ally.sevenlog.mapper.SevenLogMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenLogServiceImpl implements SevenLogService {

	@Autowired
	private SevenLogMapper sevenLogMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	@Autowired
	private SevenAccountMapper sevenAccountMapper;
	
	@Override
	public void insertLog(SevenLog logInfo) {
		// TODO Auto-generated method stub
		sevenLogMapper.insert(logInfo);
	}
	@Override
	public PageInfo<SevenLog> getSevenLogList(Integer pageNum, Integer pageSize, String lDatetime) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenLog> list = sevenLogMapper.getSevenLogList("%"+lDatetime+"%");
		for (SevenLog sevenLog : list) {
			SevenAccount sevenAccount = sevenAccountMapper.selectByPrimaryKey(sevenLog.getlAid());
			sevenLog.setStaffName(sevenStaffMapper.selectName(sevenAccount.getaSid()));
		}
		PageInfo<SevenLog> info=new PageInfo<>(list,10);
		return info;
	}
	@Override
	public PageInfo<SevenLog> getSevenLogSelfList(Integer pageNum, Integer pageSize, Integer lAid, String lDatetime) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenLog> list = sevenLogMapper.getSevenLogSelfList(lAid,lDatetime);
		for (SevenLog sevenLog : list) {
			SevenAccount sevenAccount = sevenAccountMapper.selectByPrimaryKey(lAid);
			sevenLog.setStaffName(sevenStaffMapper.selectName(sevenAccount.getaSid()));
		}
		PageInfo<SevenLog> info=new PageInfo<>(list,10);
		return info;
	}

}
