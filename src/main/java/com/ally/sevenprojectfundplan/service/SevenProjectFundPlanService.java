package com.ally.sevenprojectfundplan.service;

import com.ally.sevenprojectfundplan.bean.SevenProjectFundPlan;
import com.github.pagehelper.PageInfo;

public interface SevenProjectFundPlanService {

	Boolean addSevenProjectFundPlan(SevenProjectFundPlan sevenProjectFundPlan);

	Boolean updateSevenProjectFundPlan(SevenProjectFundPlan sevenProjectFundPlan);

	PageInfo<SevenProjectFundPlan> getSevenProjectFundPlanList(Integer page, Integer limit, Integer pfpPid);

	SevenProjectFundPlan selectSevenProjectFundPlan(Integer id);

}
