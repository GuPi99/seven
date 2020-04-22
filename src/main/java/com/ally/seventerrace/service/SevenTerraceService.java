package com.ally.seventerrace.service;

import com.ally.seventerrace.bean.SevenTerrace;
import com.github.pagehelper.PageInfo;

public interface SevenTerraceService {

	Boolean addSevenTerrace(SevenTerrace sevenTerrace);

	Boolean deleteSevenTerrace(Integer id);

	Boolean updateSevenTerrace(SevenTerrace sevenTerrace);

	SevenTerrace selectSevenTerraceById(Integer id);

	PageInfo<SevenTerrace> getSevenTerraceList(Integer page, Integer limit, Integer tFid, String tName);

	Boolean changeState(Integer id, Integer tState);

}
