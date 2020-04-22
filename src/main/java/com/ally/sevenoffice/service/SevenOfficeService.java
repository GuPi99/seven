package com.ally.sevenoffice.service;

import java.util.Date;

import com.ally.sevenoffice.bean.SevenOffice;
import com.github.pagehelper.PageInfo;

public interface SevenOfficeService {

	Boolean addSvenOffice(SevenOffice sevenOffice);

	Boolean deleteSevenOffice(Integer id);

	PageInfo<SevenOffice> getSevenOfficeList(Integer page, Integer limit, Integer oSid);

	SevenOffice selectBefore(Integer oSid);

	Boolean updateBeforeOffice(Integer id, Date oOffice);

}
