package com.ally.sevenplan.service;

import com.ally.sevenplan.bean.SevenPlan;
import com.github.pagehelper.PageInfo;

public interface SevenPlanService {

	Boolean addSevenPlan(SevenPlan sevenPlan);

	Boolean deleteSevenPlan(Integer id);

	PageInfo<SevenPlan> getSevenPlanList(Integer page, Integer limit, Integer pEid);

}
