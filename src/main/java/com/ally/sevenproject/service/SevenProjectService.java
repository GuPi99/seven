package com.ally.sevenproject.service;

import com.ally.sevenproject.bean.SevenProject;
import com.github.pagehelper.PageInfo;

public interface SevenProjectService {

	Boolean addSevenProject(SevenProject sevenProject);

	SevenProject selectSevenProjectById(Integer id);

	PageInfo<SevenProject> getSevenProjectList(Integer page, Integer limit, Integer pcState, Integer pFid,
			String pDate);

	PageInfo<SevenProject> getSevenProjectBillList(Integer page, Integer limit, Integer pFid, String pDate,
			Integer pbState);

}
