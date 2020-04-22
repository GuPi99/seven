package com.ally.seventripreport.service;

import com.ally.seventripreport.bean.SevenTripReport;
import com.github.pagehelper.PageInfo;

public interface SevenTripReportService {

	Boolean addSevenTripReport(SevenTripReport sevenTripReport);

	PageInfo<SevenTripReport> getSevenTripReportList(Integer page, Integer limit, Integer trEid);

	SevenTripReport selectTripReport(Integer trEid);

}
