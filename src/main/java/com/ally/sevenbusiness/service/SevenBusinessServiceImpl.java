package com.ally.sevenbusiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenbusiness.bean.SevenBusiness;
import com.ally.sevenbusiness.mapper.SevenBusinessMapper;
import com.ally.sevenbusinessfile.mapper.SevenBusinessFileMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenBusinessServiceImpl implements SevenBusinessService {

	@Autowired
	private SevenBusinessMapper sevenBusinessMapper;
	@Autowired
	private SevenBusinessFileMapper sevenBusinessFileMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	
	@Override
	public Boolean addSevenBusiness(SevenBusiness sevenBusiness) {
		// TODO Auto-generated method stub
		return sevenBusinessMapper.insert(sevenBusiness)>0;
	}

	@Override
	public List<SevenBusiness> getIndexList(Integer staffId) {
		// TODO Auto-generated method stub
		return sevenBusinessMapper.getIndexList(staffId);
	}

	@Override
	public Integer getIndexCount(Integer staffId) {
		// TODO Auto-generated method stub
		return sevenBusinessMapper.getIndexCount(staffId);
	}

	@Override
	public Boolean updateReadStatus(Integer id) {
		// TODO Auto-generated method stub
		return sevenBusinessMapper.updateReadStatus(id)>0;
	}

	@Override
	public PageInfo<SevenBusiness> getSevenBusinessList(Integer pageNum, Integer pageSize, String title ,
			Integer getaSid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenBusiness> list = sevenBusinessMapper.getSevenBusinessList("%"+title+"%",getaSid);
		for (SevenBusiness sevenBusiness : list) {
			sevenBusiness.setDraftName(sevenStaffMapper.selectName(sevenBusiness.getDraftId()));
			if (sevenBusiness.getBusinessId()!=null) {
				sevenBusiness.setSevenBusinessFile(sevenBusinessFileMapper.selectByPrimaryKey(sevenBusiness.getBusinessId()));
			} else {
				sevenBusiness.setSevenBusinessFile(null);
			}
			if (sevenBusiness.getStatus()==1) {
				sevenBusiness.setReadStatus("未读");
			} else {
				sevenBusiness.setReadStatus("已读");
			}
		}
		PageInfo<SevenBusiness> info = new PageInfo<>(list, 10);
		return info;
	}

}
