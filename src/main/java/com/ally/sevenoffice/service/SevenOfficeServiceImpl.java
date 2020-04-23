package com.ally.sevenoffice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenmessage.mapper.SevenMessageMapper;
import com.ally.sevenoffice.bean.SevenOffice;
import com.ally.sevenoffice.mapper.SevenOfficeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenOfficeServiceImpl implements SevenOfficeService {

	@Autowired
	private SevenOfficeMapper sevenOfficeMapper;
	@Autowired
	private SevenMessageMapper sevenMessageMapper;

	// 添加
	@Override
	public Boolean addSvenOffice(SevenOffice sevenOffice) {
		// TODO Auto-generated method stub
		return sevenOfficeMapper.insert(sevenOffice) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenOffice(Integer id) {
		// TODO Auto-generated method stub
		return sevenOfficeMapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public PageInfo<SevenOffice> getSevenOfficeList(Integer pageNum, Integer pageSize, Integer oSid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenOffice> list = sevenOfficeMapper.getSevenOfficeList(oSid);
		for (SevenOffice sevenOffice : list) {
			sevenOffice.setDepartName(sevenMessageMapper.selectName(sevenOffice.getoBranch()));
			sevenOffice.setPositionName(sevenMessageMapper.selectName(sevenOffice.getoPost()));
		}
		PageInfo<SevenOffice> info=new PageInfo<>(list,10);
		return info;
	}

	//查询之前
	@Override
	public SevenOffice selectBefore(Integer oSid) {
		// TODO Auto-generated method stub
		return sevenOfficeMapper.selectBefore(oSid);
	}

	//修改上一个离职信息
	@Override
	public Boolean updateBeforeOffice(Integer id, Date oOffice) {
		// TODO Auto-generated method stub
		return sevenOfficeMapper.updateBeforeOffice(id,oOffice)>0;
	}

}
