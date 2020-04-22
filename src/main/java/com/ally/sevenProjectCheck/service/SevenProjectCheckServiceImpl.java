package com.ally.sevenProjectCheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenProjectCheck.bean.SevenProjectCheck;
import com.ally.sevenProjectCheck.mapper.SevenProjectCheckMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenProjectCheckServiceImpl implements SevenProjectCheckService {

	@Autowired
	private SevenProjectCheckMapper sevenProjectCheckMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	
	
	@Override
	public Boolean addProjectCheck(SevenProjectCheck sevenProjectCheck) {
		// TODO Auto-generated method stub
		return sevenProjectCheckMapper.insert(sevenProjectCheck)>0;
	}


	@Override
	public PageInfo<SevenProjectCheck> getSevenProjectCheckList(Integer pageNum, Integer pageSize, Integer pcPid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenProjectCheck> list = sevenProjectCheckMapper.getSevenProjectCheckList(pcPid);
		for (SevenProjectCheck sevenProjectCheck : list) {
			sevenProjectCheck.setStaffName(sevenStaffMapper.selectName(sevenProjectCheck.getPcSid()));
			if (sevenProjectCheck.getPcState()==0) {
				sevenProjectCheck.setNowState("未审批");
			} else if (sevenProjectCheck.getPcState()==1) {
				sevenProjectCheck.setNowState("部门审批通过");
			} else if (sevenProjectCheck.getPcState()==2) {
				sevenProjectCheck.setNowState("主管审批通过");
			} else if (sevenProjectCheck.getPcState()==3) {
				sevenProjectCheck.setNowState("经理审批通过");
			} else if (sevenProjectCheck.getPcState()==-1) {
				sevenProjectCheck.setNowState("部门审批不通过");
			} else if (sevenProjectCheck.getPcState()==-2) {
				sevenProjectCheck.setNowState("主管审批不通过");
			} else if (sevenProjectCheck.getPcState()==-3) {
				sevenProjectCheck.setNowState("经理审批不通过");
			}
		}
		PageInfo<SevenProjectCheck> info=new PageInfo<>(list,10);
		return info;
	}


	@Override
	public Boolean updateOther(Integer pcPid) {
		// TODO Auto-generated method stub
		return sevenProjectCheckMapper.updateOther(pcPid)>0;
	}

}
