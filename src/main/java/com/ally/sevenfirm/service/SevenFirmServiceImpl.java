package com.ally.sevenfirm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ally.sevenfirm.bean.SevenFirm;
import com.ally.sevenfirm.mapper.SevenFirmMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenFirmServiceImpl implements SevenFirmService {

	@Autowired
	private SevenFirmMapper sevenFirmMapper;

	// 添加
	@Override
	public Boolean addSevenFirm(SevenFirm sevenFirm) {
		// TODO Auto-generated method stub
		return sevenFirmMapper.insert(sevenFirm) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenFirm(Integer id) {
		// TODO Auto-generated method stub
		return sevenFirmMapper.deleteByPrimaryKey(id) > 0;
	}

	// 查询单个
	@Override
	public SevenFirm selectSevenFirm(Integer id) {
		// TODO Auto-generated method stub
		return sevenFirmMapper.selectByPrimaryKey(id);
	}

	// 修改
	@Override
	public Boolean updateSevenFirm(SevenFirm sevenFirm) {
		// TODO Auto-generated method stub
		return sevenFirmMapper.updateByPrimaryKey(sevenFirm) > 0;
	}

	// 查询全部
	@Override
	public List<SevenFirm> selectAll() {
		// TODO Auto-generated method stub
		return sevenFirmMapper.selectAll();
	}

	//分页模糊查询
	@Override
	public PageInfo<SevenFirm> getSevenFirmList(Integer pageNum, Integer pageSize, String fName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenFirm> list = sevenFirmMapper.getSevenFirmList("%"+fName+"%");
		for (SevenFirm sevenFirm : list) {
			if (sevenFirm.getfFid()==0) {
				sevenFirm.setCompanyName("总公司");
			}else {
				sevenFirm.setCompanyName(sevenFirmMapper.selectName(sevenFirm.getfFid()));
			}
		}
		PageInfo<SevenFirm> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public List<SevenFirm> selectUnderFirm(Integer id) {
		// TODO Auto-generated method stub
		return sevenFirmMapper.selectUnderFirm(id);
	}

	@Override
	public Boolean batchFirm(List<SevenFirm> list) {
		// TODO Auto-generated method stub
		return sevenFirmMapper.batchFirm(list)==list.size();
	}


}
