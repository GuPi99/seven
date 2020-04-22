package com.ally.sevenclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenclass.bean.SevenClass;
import com.ally.sevenclass.mapper.SevenClassMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenClassServiceImpl implements SevenClassService {

	@Autowired
	private SevenClassMapper sevenClassMapper;
	
	//添加
	@Override
	public Boolean addSevenClass(SevenClass sevenClass) {
		// TODO Auto-generated method stub
		return sevenClassMapper.insert(sevenClass)>0;
	}
	
	//删除
	@Override
	public Boolean deleteSevenClass(Integer id) {
		// TODO Auto-generated method stub
		return sevenClassMapper.deleteByPrimaryKey(id)>0;
	}
	
	//查询单个类型
	@Override
	public SevenClass selectSevenClass(Integer id) {
		// TODO Auto-generated method stub
		return sevenClassMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<SevenClass> selectAll() {
		// TODO Auto-generated method stub
		return sevenClassMapper.selectAll();
	}

	//修改产品类型信息
	@Override
	public Boolean updateSevenClass(SevenClass sevenClass) {
		// TODO Auto-generated method stub
		return sevenClassMapper.updateByPrimaryKey(sevenClass)>0;
	}

	//分页查询
	@Override
	public PageInfo<SevenClass> getSevenClassList(Integer pageNum, Integer pageSize,String cName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenClass> list = sevenClassMapper.getSevenClassList("%"+cName+"%");
		PageInfo<SevenClass> info=new PageInfo<>(list,10);
		return info;
	}

	//查询全部名称
	@Override
	public List<SevenClass> selectAllName() {
		// TODO Auto-generated method stub
		return sevenClassMapper.selectAllName();
	}


}
