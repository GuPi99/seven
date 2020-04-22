package com.ally.sevenmelt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenmelt.bean.SevenMelt;
import com.ally.sevenmelt.mapper.SevenMeltMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenMeltServiceImpl implements SevenMeltService {

	@Autowired
	private SevenMeltMapper sevenMeltMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	
	//添加报销
	@Override
	public Boolean addSevenMelt(SevenMelt sevenMelt) {
		// TODO Auto-generated method stub
		return sevenMeltMapper.insert(sevenMelt)>0;
	}

	//部门审批
	@Override
	public Boolean addBranch(SevenMelt sevenMelt) {
		// TODO Auto-generated method stub
		return sevenMeltMapper.addBranch(sevenMelt)>0;
	}

	//主管审批
	@Override
	public Boolean addDirector(SevenMelt sevenMelt) {
		// TODO Auto-generated method stub
		return sevenMeltMapper.addDirector(sevenMelt)>0;
	}

	//经理审批
	@Override
	public Boolean addManger(SevenMelt sevenMelt) {
		// TODO Auto-generated method stub
		return sevenMeltMapper.addManger(sevenMelt)>0;
	}

	@Override
	public SevenMelt selectSevenMelt(Integer id) {
		// TODO Auto-generated method stub
		return sevenMeltMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenMelt> getSevenMeltList(Integer pageNum, Integer pageSize, Integer mSid, Integer mState,
			String mApplyTime, String mItems) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenMelt> list = sevenMeltMapper.getSevenMeltList(mSid,mState,"%"+mApplyTime+"%","%"+mItems+"%");
		for (SevenMelt sevenMelt : list) {
			sevenMelt.setStaffName(sevenStaffMapper.selectName(sevenMelt.getmSid()));
			if (sevenMelt.getmState()==0) {
				sevenMelt.setNowState("未审批");
			} else if (sevenMelt.getmState()==1) {
				sevenMelt.setNowState("部门审批通过");
			} else if (sevenMelt.getmState()==2) {
				sevenMelt.setNowState("主管审批通过");
			} else if (sevenMelt.getmState()==3) {
				sevenMelt.setNowState("经理审批通过");
			} else if (sevenMelt.getmState()==-1) {
				sevenMelt.setNowState("部门审批不通过");
			} else if (sevenMelt.getmState()==-2) {
				sevenMelt.setNowState("主管审批不通过");
			} else if (sevenMelt.getmState()==-3) {
				sevenMelt.setNowState("经理审批不通过");
			}
		}
		PageInfo<SevenMelt> info = new PageInfo<>(list, 10);
		return info;
	}

}
