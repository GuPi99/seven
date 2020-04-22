package com.ally.sevenassigned.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenassigned.bean.SevenAssigned;
import com.ally.sevenassigned.mapper.SevenAssignedMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenAssignedServiceImpl implements SevenAssignedService {

	@Autowired
	private SevenAssignedMapper sevenAssignedMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;

	// 添加
	@Override
	public Boolean addSevenAssigned(SevenAssigned sevenAssigned) {
		// TODO Auto-generated method stub
		return sevenAssignedMapper.insert(sevenAssigned) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenAssigned(Integer id) {
		// TODO Auto-generated method stub
		return sevenAssignedMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenAssigned(SevenAssigned sevenAssigned) {
		// TODO Auto-generated method stub
		return sevenAssignedMapper.updateByPrimaryKey(sevenAssigned) > 0;
	}

	// 查看
	@Override
	public SevenAssigned selectSevenAssignedById(Integer id) {
		// TODO Auto-generated method stub
		return sevenAssignedMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenAssigned> getSevenAssignedList(Integer pageNum, Integer pageSize, Integer aState, Integer aSid,
			String aWork) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenAssigned> list = sevenAssignedMapper.getSevenAssignedList(aState,aSid,"%"+aWork+"%");
		for (SevenAssigned sevenAssigned : list) {
			sevenAssigned.setStaffName(sevenStaffMapper.selectName(sevenAssigned.getaSid()));
			if (sevenAssigned.getaState()==0) {
				sevenAssigned.setState("已下派");
			} else {
				sevenAssigned.setState("已完成");
			}
			if (sevenAssigned.getaRead()==0) {
				sevenAssigned.setReadStatus("未读");
			} else {
				sevenAssigned.setReadStatus("已读");
			}
		}
		PageInfo<SevenAssigned> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public Boolean updateState(SevenAssigned sevenAssigned) {
		// TODO Auto-generated method stub
		return sevenAssignedMapper.updateState(sevenAssigned) > 0;
	}

	@Override
	public Boolean updateReadStatus(Integer id) {
		// TODO Auto-generated method stub
		return sevenAssignedMapper.updateReadStatus(id)>0;
	}

	@Override
	public List<SevenAssigned> getIndexList(Integer aSid) {
		// TODO Auto-generated method stub
		return sevenAssignedMapper.getIndexList(aSid);
	}

	@Override
	public Integer getIndexCount(Integer aSid) {
		// TODO Auto-generated method stub
		return sevenAssignedMapper.getIndexCount(aSid);
	}



}
