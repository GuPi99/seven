package com.ally.sevenassigned.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenassigned.bean.SevenAssigned;

public interface SevenAssignedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenAssigned record);

    SevenAssigned selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SevenAssigned record);

	Integer getCount();

	List<SevenAssigned> getSevenAssignedList(@Param("aState")Integer aState, @Param("aSid")Integer aSid, @Param("aWork")String string);

	int updateState(SevenAssigned sevenAssigned);

	int updateReadStatus(@Param("id")Integer id);

	List<SevenAssigned> getIndexList(@Param("aSid")Integer aSid);

	Integer getIndexCount(@Param("aSid")Integer aSid);
}