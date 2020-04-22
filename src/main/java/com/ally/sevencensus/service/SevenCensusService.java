package com.ally.sevencensus.service;

import java.util.List;

import com.ally.sevencensus.bean.SevenCensus;
import com.github.pagehelper.PageInfo;

public interface SevenCensusService {

	Boolean addSevenCensus(SevenCensus sevenCensus);

	PageInfo<SevenCensus> getSevenCensusList(Integer page, Integer limit, Integer productId, String censusDate);

	List<SevenCensus> getCensusNumber(String censusDate);

	List<SevenCensus> getCensusMoney(String censusDate);


}
