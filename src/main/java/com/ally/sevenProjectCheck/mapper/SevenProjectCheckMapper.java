package com.ally.sevenProjectCheck.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenProjectCheck.bean.SevenProjectCheck;

public interface SevenProjectCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenProjectCheck record);

    SevenProjectCheck selectByPrimaryKey(Integer id);

    List<SevenProjectCheck> selectAll();

    int updateByPrimaryKey(SevenProjectCheck record);

	SevenProjectCheck selectCheck(@Param("pcPid")Integer id);

	List<SevenProjectCheck> getSevenProjectCheckList(@Param("pcPid")Integer pcPid);

	int updateOther(@Param("pcPid")Integer pcPid);
}