package com.ally.sevenvisit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenvisit.bean.SevenVisit;
import com.ally.sevenvisit.mapper.SevenVisitMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenVisitServiceImpl implements SevenVisitService {

	@Autowired
	private SevenVisitMapper sevenVisitMapper;
	
	@Override
	public PageInfo<SevenVisit> getSevenVisitList(Integer pageNum, Integer pageSize, Integer vEid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenVisit> list = sevenVisitMapper.getSevenVisitList(vEid);
		PageInfo<SevenVisit> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public Boolean deleteSevenVisit(Integer id) {
		// TODO Auto-generated method stub
		return sevenVisitMapper.deleteByPrimaryKey(id)>0;
	}

	@Override
	public Boolean addSevenVisit(SevenVisit sevenVisit) {
		// TODO Auto-generated method stub
		return sevenVisitMapper.insert(sevenVisit)>0;
	}

}
