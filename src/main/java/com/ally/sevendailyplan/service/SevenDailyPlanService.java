package com.ally.sevendailyplan.service;

import com.ally.sevendailyplan.bean.SevenDailyPlan;
import com.github.pagehelper.PageInfo;

public interface SevenDailyPlanService {

	Boolean addSevenDailyPlan(SevenDailyPlan sevenDailyPlan);

	Boolean deleteSevenDailyPlan(Integer id);

	Boolean updateSevenDailyPlan(SevenDailyPlan sevenDailyPlan);

	SevenDailyPlan selectSevenDailyPlanById(Integer id);

	PageInfo<SevenDailyPlan> getAllDayList(Integer page, Integer limit, Integer dpSid, Integer dpWhere,String dpDate);

	PageInfo<SevenDailyPlan> getSelfDayList(Integer page, Integer limit, Integer getaSid, Integer dpWhere,
			String dpDate);

	PageInfo<SevenDailyPlan> getSelfWeekList(Integer page, Integer limit, Integer getaSid, Integer dpWhere,
			String dpDate);


}
