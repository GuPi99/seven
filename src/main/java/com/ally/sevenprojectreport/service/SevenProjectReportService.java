package com.ally.sevenprojectreport.service;

import com.ally.sevenprojectreport.bean.SevenProjectReport;

public interface SevenProjectReportService {

	Boolean addSevenProjectReport(SevenProjectReport sevenProjectReport);

	SevenProjectReport selectProjectReport(Integer prPid);

}
