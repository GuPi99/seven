package com.ally.sevenstaff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenstaff.bean.SevenStaff;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenStaffServiceImpl implements SevenStaffService {

	@Autowired
	private SevenStaffMapper sevenStaffMapper;

	// 添加
	@Override
	public Boolean addSevenStaff(SevenStaff sevenStaff) {
		// TODO Auto-generated method stub
		return sevenStaffMapper.insert(sevenStaff) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenStaff(Integer id) {
		// TODO Auto-generated method stub
		return sevenStaffMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenStaff(SevenStaff sevenStaff) {
		// TODO Auto-generated method stub
		return sevenStaffMapper.updateByPrimaryKey(sevenStaff) > 0;
	}

	// 查询
	@Override
	public SevenStaff selectSevenStaffById(Integer id) {
		// TODO Auto-generated method stub
		SevenStaff sevenStaff = sevenStaffMapper.selectByPrimaryKey(id);
		if (sevenStaff.getsSex()==0) {
			sevenStaff.setSex("男");
		} else {
			sevenStaff.setSex("女");
		}
		return sevenStaff;
	}

	// 修改员工状态
	@Override
	public Boolean updateSevenStaffState(Integer id, Integer sState) {
		// TODO Auto-generated method stub
		return sevenStaffMapper.updateSevenStaffState(id, sState) > 0;
	}

	// 查询全部
	@Override
	public List<SevenStaff> selectAll() {
		// TODO Auto-generated method stub
		return sevenStaffMapper.selectAll();
	}

	@Override
	public PageInfo<SevenStaff> getSevenStaffList(Integer pageNum, Integer pageSize, Integer sSex, String sName,
			String sDateBirth) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenStaff> list = sevenStaffMapper.getSevenStaffList(sSex, "%" + sName + "%", "%"+sDateBirth+"%");
		for (SevenStaff sevenStaff : list) {
			if (sevenStaff.getsState()==1) {
				sevenStaff.setState("在职");
			} else {
				sevenStaff.setState("离职");
			}
			if (sevenStaff.getsSex()==0) {
				sevenStaff.setSex("男");
			} else {
				sevenStaff.setSex("女");
			}
		}
		PageInfo<SevenStaff> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public List<SevenStaff> selectNoAccount() {
		// TODO Auto-generated method stub
		return sevenStaffMapper.selectNoAccount();
	}


}
