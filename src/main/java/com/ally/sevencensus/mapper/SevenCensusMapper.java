package com.ally.sevencensus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevencensus.bean.SevenCensus;

public interface SevenCensusMapper {
    int insert(SevenCensus record);

	List<SevenCensus> getSevenCensusList(@Param("productId")Integer productId, @Param("censusDate")String string);

	List<SevenCensus> getCensusNumber(@Param("censusDate")String string);

	List<SevenCensus> getCensusMoney(@Param("censusDate")String string);

}