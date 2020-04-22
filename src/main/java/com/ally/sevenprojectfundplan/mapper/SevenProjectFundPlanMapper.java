package com.ally.sevenprojectfundplan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenprojectfundplan.bean.SevenProjectFundPlan;

public interface SevenProjectFundPlanMapper {
    int insert(SevenProjectFundPlan record);

	int updateSevenProjectFundPlan(SevenProjectFundPlan sevenProjectFundPlan);

	List<SevenProjectFundPlan> getSevenProjectFundPlanList(@Param("pfpPid")Integer pfpPid);

	SevenProjectFundPlan selectSevenProjectFundPlan(Integer id);
}