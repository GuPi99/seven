package com.ally.sevenProjectCheck.service;

import com.ally.sevenProjectCheck.bean.SevenProjectCheck;
import com.github.pagehelper.PageInfo;

public interface SevenProjectCheckService {

	Boolean addProjectCheck(SevenProjectCheck sevenProjectCheck);

	PageInfo<SevenProjectCheck> getSevenProjectCheckList(Integer page, Integer limit, Integer pcPid);

	Boolean updateOther(Integer pcPid);

}
