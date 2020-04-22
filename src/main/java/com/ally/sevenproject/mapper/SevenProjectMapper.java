package com.ally.sevenproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenproject.bean.SevenProject;

public interface SevenProjectMapper {
	int insert(SevenProject record);

	SevenProject selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(SevenProject record);

	List<SevenProject> getSevenProjectList(@Param("pcState") Integer pcState, @Param("pFid") Integer pFid,
			@Param("pDate") String pDate);

	List<SevenProject> getSevenProjectBillList(@Param("pFid")Integer pFid, @Param("pDate")String pDate, @Param("pbState")Integer pbState);

}