package com.ally.sevenbusinessfile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenbusinessfile.bean.SevenBusinessFile;
import com.ally.sevenbusinessfile.mapper.SevenBusinessFileMapper;

@Service
public class SevenBusinessFileServiceImpl implements SevenBusinessFileService {

	@Autowired
	private SevenBusinessFileMapper sevenBusinessFileMapper;
	@Override
	public Boolean addBusinessFile(SevenBusinessFile sevenBusinessFile) {
		// TODO Auto-generated method stub
		return sevenBusinessFileMapper.insert(sevenBusinessFile)>0;
	}

}
