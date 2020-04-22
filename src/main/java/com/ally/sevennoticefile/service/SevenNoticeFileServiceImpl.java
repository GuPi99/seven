package com.ally.sevennoticefile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevennoticefile.bean.SevenNoticeFile;
import com.ally.sevennoticefile.mapper.SevenNoticeFileMapper;

@Service
public class SevenNoticeFileServiceImpl implements SevenNoticeFileService {

	@Autowired
	private SevenNoticeFileMapper sevenNoticeFileMapper;
	@Override
	public Boolean addNoticeFile(SevenNoticeFile sevenNoticeFile) {
		// TODO Auto-generated method stub
		return sevenNoticeFileMapper.insert(sevenNoticeFile)>0;
	}

}
