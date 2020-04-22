package com.ally.sevenprojectfile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenprojectfile.bean.SevenProjectFile;
import com.ally.sevenprojectfile.mapper.SevenProjectFileMapper;
import com.ally.sevenprojectgoods.bean.SevenProjectGoods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenProjectFileServiceImpl implements SevenProjectFileService {

	@Autowired
	private SevenProjectFileMapper sevenProjectFileMapper;

	// 添加
	@Override
	public Boolean addSevenProjectFile(SevenProjectFile sevenProjectFile) {
		// TODO Auto-generated method stub
		return sevenProjectFileMapper.insert(sevenProjectFile) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenProjectFile(Integer id) {
		// TODO Auto-generated method stub
		return sevenProjectFileMapper.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public PageInfo<SevenProjectGoods> getSevenProjectFileList(Integer pageNum, Integer pageSize, Integer pfPid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenProjectGoods> list = sevenProjectFileMapper.getSevenProjectFileList(pfPid);
		PageInfo<SevenProjectGoods> info=new PageInfo<>(list,10);
		return info;
	}

}
