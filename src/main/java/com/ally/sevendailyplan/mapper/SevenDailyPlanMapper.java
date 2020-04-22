package com.ally.sevendailyplan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevendailyplan.bean.SevenDailyPlan;

public interface SevenDailyPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenDailyPlan record);

    SevenDailyPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SevenDailyPlan record);

	List<SevenDailyPlan> getSevenDailyPlanList(@Param("dpSid")Integer dpSid,@Param("dpType")Integer dpType, @Param("dpDate")String string);

	List<SevenDailyPlan> getSelfDayList(@Param("dpSid")Integer getaSid, @Param("dpWhere")Integer dpWhere, @Param("dpDate")String string);

	List<SevenDailyPlan> getSelfWeekList(@Param("dpSid")Integer getaSid, @Param("dpWhere")Integer dpWhere, @Param("dpDate")String string);
}