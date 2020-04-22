package com.ally.sevenassigned.service;

import java.util.List;

import com.ally.sevenassigned.bean.SevenAssigned;
import com.github.pagehelper.PageInfo;

public interface SevenAssignedService {

	Boolean addSevenAssigned(SevenAssigned sevenAssigned);

	Boolean deleteSevenAssigned(Integer id);

	Boolean updateSevenAssigned(SevenAssigned sevenAssigned);

	SevenAssigned selectSevenAssignedById(Integer id);

	PageInfo<SevenAssigned> getSevenAssignedList(Integer page, Integer limit, Integer aState, Integer aSid,
			String aWork);

	Boolean updateState(SevenAssigned sevenAssigned);

	Boolean updateReadStatus(Integer id);

	List<SevenAssigned> getIndexList(Integer aSid);

	Integer getIndexCount(Integer aSid);


}
