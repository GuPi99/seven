package com.ally.sevenvacate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.ally.sevenvacate.bean.SevenVacate;
import com.ally.sevenvacate.mapper.SevenVacateMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenVacateServiceImpl implements SevenVacateService {

	@Autowired
	private SevenVacateMapper sevenVacateMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	
	@Override
	public Boolean addSevenVacate(SevenVacate sevenVacate) {
		// TODO Auto-generated method stub
		return sevenVacateMapper.insert(sevenVacate)>0;
	}
	@Override
	public SevenVacate selectSevenVacate(Integer id) {
		// TODO Auto-generated method stub
		SevenVacate sevenVacate = sevenVacateMapper.selectByPrimaryKey(id);
		return sevenVacate;
	}
	@Override
	public PageInfo<SevenVacate> getSevenVacatetList(Integer pageNum, Integer pageSize, Integer vSid, Integer vSate,
			String vStart, String vEnd) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenVacate> list = sevenVacateMapper.getSevenVacatetList(vSid,vSate,"%"+vStart+"%","%"+vEnd+"%");
		for (SevenVacate sevenVacate : list) {
			sevenVacate.setStaffName(sevenStaffMapper.selectName(sevenVacate.getvSid()));
			if (sevenVacate.getvSate()==0) {
				sevenVacate.setNowState("未审批");
			} else if (sevenVacate.getvSate()==1) {
				sevenVacate.setNowState("部门审批通过");
			} else if (sevenVacate.getvSate()==2) {
				sevenVacate.setNowState("主管审批通过");
			} else if (sevenVacate.getvSate()==3) {
				sevenVacate.setNowState("经理审批通过");
			} else if (sevenVacate.getvSate()==-1) {
				sevenVacate.setNowState("部门审批不通过");
			} else if (sevenVacate.getvSate()==-2) {
				sevenVacate.setNowState("主管审批不通过");
			} else if (sevenVacate.getvSate()==-3) {
				sevenVacate.setNowState("经理审批不通过");
			}
		}
		PageInfo<SevenVacate> info = new PageInfo<>(list, 10);
		return info;
	}
	@Override
	public Boolean addBranch(SevenVacate sevenVacate) {
		// TODO Auto-generated method stub
		return sevenVacateMapper.addBranch(sevenVacate)>0;
	}
	@Override
	public Boolean addDirector(SevenVacate sevenVacate) {
		// TODO Auto-generated method stub
		return sevenVacateMapper.addDirector(sevenVacate)>0;
	}
	@Override
	public Boolean addManger(SevenVacate sevenVacate) {
		// TODO Auto-generated method stub
		return sevenVacateMapper.addManger(sevenVacate)>0;
	}

}
