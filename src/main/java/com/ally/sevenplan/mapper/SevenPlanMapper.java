package com.ally.sevenplan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenplan.bean.SevenPlan;

public interface SevenPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenPlan record);

    SevenPlan selectByPrimaryKey(Integer id);

    List<SevenPlan> selectAll();

    int updateByPrimaryKey(SevenPlan record);

	List<SevenPlan> getSevenPlanList(@Param("pEid")Integer pEid);
}