package com.ally.sevennotice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevennotice.bean.SevenNotice;
import com.ally.sevennotice.mapper.SevenNoticeMapper;
import com.ally.sevennoticefile.mapper.SevenNoticeFileMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenNoticeSerivceImpl implements SevenNoticeSerivce {

	@Autowired
	private SevenNoticeMapper sevenNoticeMapper;
	@Autowired
	private SevenNoticeFileMapper sevenNoticeFileMapper;
	
	@Override
	public Boolean addSevenNotice(SevenNotice sevenNotice) {
		// TODO Auto-generated method stub
		return sevenNoticeMapper.insert(sevenNotice)>0;
	}

	@Override
	public PageInfo<SevenNotice> getSevenNoticeList(Integer pageNum, Integer pageSize, String title) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenNotice> list = sevenNoticeMapper.getSevenNoticeList("%"+title+"%");
		for (SevenNotice sevenNotice : list) {
			if (sevenNotice.getNationFileId()!=null) {
				sevenNotice.setSevenNoticeFile(sevenNoticeFileMapper.selectByPrimaryKey(sevenNotice.getNationFileId()));
			} else {
				sevenNotice.setSevenNoticeFile(null);
			}
		}
		PageInfo<SevenNotice> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public List<SevenNotice> getIndexList() {
		// TODO Auto-generated method stub
		return sevenNoticeMapper.getIndexList();
	}

}
