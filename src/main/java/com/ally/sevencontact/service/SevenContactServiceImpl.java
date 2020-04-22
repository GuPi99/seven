package com.ally.sevencontact.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevencontact.bean.SevenContact;
import com.ally.sevencontact.mapper.SevenContactMapper;
import com.ally.sevenfirm.mapper.SevenFirmMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenContactServiceImpl implements SevenContactService {

	@Autowired
	private SevenContactMapper sevenContactMapper;
	@Autowired
	private SevenFirmMapper sevenFirmMapper;

	// 添加
	@Override
	public Boolean addSevenContact(SevenContact sevenContact) {
		// TODO Auto-generated method stub
		return sevenContactMapper.insert(sevenContact) > 0;
	}

	// 删除
	@Override
	public Boolean deleteSevenContact(Integer id) {
		// TODO Auto-generated method stub
		return sevenContactMapper.deleteByPrimaryKey(id) > 0;
	}

	// 修改
	@Override
	public Boolean updateSevenContact(SevenContact sevenContact) {
		// TODO Auto-generated method stub
		return sevenContactMapper.updateByPrimaryKey(sevenContact) > 0;
	}

	// 查看
	@Override
	public SevenContact selectSevenContact(Integer id) {
		// TODO Auto-generated method stub
		SevenContact sevenContact = sevenContactMapper.selectByPrimaryKey(id);
		sevenContact.setFirmName(sevenFirmMapper.selectByPrimaryKey(sevenContact.getcFid()).getfName());
		return sevenContact;
	}

	@Override
	public PageInfo<SevenContact> getSevenContactList(Integer pageNum, Integer pageSize, Integer cFid, String cName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenContact> list = sevenContactMapper.getSevenContactList(cFid,"%"+cName+"%");
		for (SevenContact sevenContact : list) {
			sevenFirmMapper.selectByPrimaryKey(sevenContact.getcFid());
			sevenContact.setFirmName(sevenFirmMapper.selectByPrimaryKey(sevenContact.getcFid()).getfName());
			if (sevenContact.getcSex()==0) {
				sevenContact.setSex("男");
			} else {
				sevenContact.setSex("女");
			}
		}
		PageInfo<SevenContact> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public Boolean changeState(Integer id, Integer cState) {
		// TODO Auto-generated method stub
		return sevenContactMapper.changeState(id,cState)>0;
	}

	@Override
	public List<SevenContact> selectContactList(Integer id) {
		// TODO Auto-generated method stub
		return sevenContactMapper.selectContactList(id);
	}



}
