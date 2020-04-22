package com.ally.sevenbusiness.service;

import java.util.List;

import com.ally.sevenbusiness.bean.SevenBusiness;
import com.github.pagehelper.PageInfo;

public interface SevenBusinessService {

	Boolean addSevenBusiness(SevenBusiness sevenBusiness);

	List<SevenBusiness> getIndexList(Integer staffId);

	Integer getIndexCount(Integer staffId);

	Boolean updateReadStatus(Integer id);

	PageInfo<SevenBusiness> getSevenBusinessList(Integer page, Integer limit, String title, Integer getaSid);

}
