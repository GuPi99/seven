package com.ally.sevenprojectreport.mapper;


import org.apache.ibatis.annotations.Param;

import com.ally.sevenprojectreport.bean.SevenProjectReport;

public interface SevenProjectReportMapper {
    int insert(SevenProjectReport record);

	SevenProjectReport selectProjectReport(@Param("prPid")Integer prPid);
}