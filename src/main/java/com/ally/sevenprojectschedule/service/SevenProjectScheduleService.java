package com.ally.sevenprojectschedule.service;

import com.ally.sevenprojectschedule.bean.SevenProjectSchedule;
import com.github.pagehelper.PageInfo;

public interface SevenProjectScheduleService {

	PageInfo<SevenProjectSchedule> getSevenProjectScheduleList(Integer page, Integer limit, Integer psPid);

	Boolean addSevenProjectSchedule(SevenProjectSchedule sevenProjectSchedule);

}
