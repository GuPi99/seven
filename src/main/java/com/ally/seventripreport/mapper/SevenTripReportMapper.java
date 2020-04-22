package com.ally.seventripreport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.seventripreport.bean.SevenTripReport;

public interface SevenTripReportMapper {
    int insert(SevenTripReport record);

	List<SevenTripReport> getSevenTripReportList(@Param("trEid")Integer trEid);

	SevenTripReport selectTripReport(@Param("trEid")Integer trEid);
}