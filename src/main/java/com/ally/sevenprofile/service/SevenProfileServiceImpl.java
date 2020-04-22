package com.ally.sevenprofile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenfirm.mapper.SevenFirmMapper;
import com.ally.sevenprofile.bean.SevenProfile;
import com.ally.sevenprofile.mapper.SevenProfileMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenProfileServiceImpl implements SevenProfileService {

	@Autowired
	private SevenProfileMapper sevenProfileMapper;
	@Autowired
	private SevenFirmMapper sevenFirmMapper;

	// 添加
	@Override
	public Boolean addSevenProfile(SevenProfile sevenProfile) {
		// TODO Auto-generated method stub
		return sevenProfileMapper.insert(sevenProfile) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenProfile(Integer id) {
		// TODO Auto-generated method stub
		return sevenProfileMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenProfile(SevenProfile sevenProfile) {
		// TODO Auto-generated method stub
		return sevenProfileMapper.updateByPrimaryKey(sevenProfile) > 0;
	}

	// 查询
	@Override
	public SevenProfile selectSevenProfile(Integer id) {
		// TODO Auto-generated method stub
		return sevenProfileMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenProfile> getSevenProfileList(Integer pageNum, Integer pageSize, Integer pFid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenProfile> list = sevenProfileMapper.getSevenProfileList(pFid);
		for (SevenProfile sevenProfile : list) {
			sevenProfile.setFirmName(sevenFirmMapper.selectName(sevenProfile.getpFid()));
		}
		PageInfo<SevenProfile> info=new PageInfo<>(list,10);
		return info;
	}


}
