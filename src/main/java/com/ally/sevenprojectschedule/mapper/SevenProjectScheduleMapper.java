package com.ally.sevenprojectschedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenprojectschedule.bean.SevenProjectSchedule;

public interface SevenProjectScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenProjectSchedule record);

    SevenProjectSchedule selectByPrimaryKey(Integer id);

    List<SevenProjectSchedule> selectAll();

    int updateByPrimaryKey(SevenProjectSchedule record);

	List<SevenProjectSchedule> getSevenProjectScheduleList(@Param("psPid")Integer psPid);
}