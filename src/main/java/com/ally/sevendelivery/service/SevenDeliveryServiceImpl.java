package com.ally.sevendelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevendelivery.bean.SevenDelivery;
import com.ally.sevendelivery.mapper.SevenDeliveryMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenDeliveryServiceImpl implements SevenDeliveryService {

	@Autowired
	private SevenDeliveryMapper sevenDeliveryMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	
	@Override
	public Boolean addSevenDelivery(SevenDelivery sevenDelivery) {
		// TODO Auto-generated method stub
		return sevenDeliveryMapper.insert(sevenDelivery)>0;
	}

	@Override
	public Boolean addBranch(SevenDelivery sevenDelivery) {
		// TODO Auto-generated method stub
		return sevenDeliveryMapper.addBranch(sevenDelivery)>0;
	}

	@Override
	public Boolean addDirector(SevenDelivery sevenDelivery) {
		// TODO Auto-generated method stub
		return sevenDeliveryMapper.addDirector(sevenDelivery)>0;
	}

	@Override
	public Boolean addManger(SevenDelivery sevenDelivery) {
		// TODO Auto-generated method stub
		System.out.println("111");
		return sevenDeliveryMapper.addManger(sevenDelivery)>0;
	}

	@Override
	public SevenDelivery selectSevenDelivery(Integer id) {
		// TODO Auto-generated method stub
		return sevenDeliveryMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenDelivery> getSevenDeliveryList(Integer pageNum, Integer pageSize, Integer dSid,Integer applicationState,  String projectNum,
			String projectName, String applicationDate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenDelivery> list = sevenDeliveryMapper.getSevenDeliveryList(dSid,applicationState,"%"+projectNum+"%","%"+projectName+"%","%"+applicationDate+"%");
		for (SevenDelivery sevenDelivery : list) {
			sevenDelivery.setStaffName(sevenStaffMapper.selectName(sevenDelivery.getdSid()));
			if (sevenDelivery.getApplicationState()==0) {
				sevenDelivery.setNowState("未审批");
			} else if (sevenDelivery.getApplicationState()==1) {
				sevenDelivery.setNowState("部门审批通过");
			} else if (sevenDelivery.getApplicationState()==2) {
				sevenDelivery.setNowState("主管审批通过");
			} else if (sevenDelivery.getApplicationState()==3) {
				sevenDelivery.setNowState("经理审批通过");
			} else if (sevenDelivery.getApplicationState()==-1) {
				sevenDelivery.setNowState("部门审批不通过");
			} else if (sevenDelivery.getApplicationState()==-2) {
				sevenDelivery.setNowState("主管审批不通过");
			} else if (sevenDelivery.getApplicationState()==-3) {
				sevenDelivery.setNowState("经理审批不通过");
			}
		}
		PageInfo<SevenDelivery> info = new PageInfo<>(list, 10);
		return info;
	}

}
