package com.ally.sevenevection.service;

import java.util.List;

import com.ally.sevenevection.bean.SevenEvection;
import com.github.pagehelper.PageInfo;

public interface SevenEvectionService {

	Boolean addSevenVacate(SevenEvection sevenEvection);

	Boolean addBranch(SevenEvection sevenEvection);

	Boolean addDirector(SevenEvection sevenEvection);

	Boolean addManger(SevenEvection sevenEvection);

	SevenEvection selectSevenEvection(Integer id);

	PageInfo<SevenEvection> getSevenEvectionList(Integer page, Integer limit, Integer eSid, Integer eState, String eGoal,
			String eApplyTime);

	List<SevenEvection> getIndexList(Integer getaSid, String now, String after);

}
