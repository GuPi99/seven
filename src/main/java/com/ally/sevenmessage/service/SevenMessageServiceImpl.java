package com.ally.sevenmessage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenmessage.bean.SevenMessage;
import com.ally.sevenmessage.mapper.SevenMessageMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenMessageServiceImpl implements SevenMessageService {

	@Autowired
	private SevenMessageMapper sevenMessageMapper;

	// 添加
	@Override
	public Boolean addSevenMessage(SevenMessage sevenMessage) {
		// TODO Auto-generated method stub
		return sevenMessageMapper.insert(sevenMessage) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenMessage(Integer id) {
		// TODO Auto-generated method stub
		return sevenMessageMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenMessage(SevenMessage sevenMessage) {
		// TODO Auto-generated method stub
		return sevenMessageMapper.updateByPrimaryKey(sevenMessage) > 0;
	}

	// 查询
	@Override
	public SevenMessage selectSevenMessageById(Integer id) {
		// TODO Auto-generated method stub
		return sevenMessageMapper.selectByPrimaryKey(id);
	}

	//分页
	@Override
	public PageInfo<SevenMessage> getSevenMessageList(Integer pageNum, Integer pageSize, String mName, Integer mType) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenMessage> list = sevenMessageMapper.getSevenMessageList("%"+mName+"%",mType);
		PageInfo<SevenMessage> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public List<SevenMessage> selectDepart() {
		// TODO Auto-generated method stub
		return sevenMessageMapper.selectDepart();
	}

	@Override
	public List<SevenMessage> selectPosition() {
		// TODO Auto-generated method stub
		return sevenMessageMapper.selectPosition();
	}



}
