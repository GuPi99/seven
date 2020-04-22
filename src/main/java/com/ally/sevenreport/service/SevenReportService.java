package com.ally.sevenreport.service;

import com.ally.sevenreport.bean.SevenReport;
import com.github.pagehelper.PageInfo;

public interface SevenReportService {

	Boolean addSevenReport(SevenReport sevenReport);

	Boolean updateSevenReport(SevenReport sevenReport);

	PageInfo<SevenReport> getSevenReportList(Integer page, Integer limit, Integer rSid, String rDate, String rTitle);

	SevenReport selectSevenReport(Integer id);

	Boolean addIndicate(SevenReport sevenReport);

	Boolean addReply(SevenReport sevenReport);


}
