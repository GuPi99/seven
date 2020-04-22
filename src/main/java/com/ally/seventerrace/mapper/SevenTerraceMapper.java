package com.ally.seventerrace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.seventerrace.bean.SevenTerrace;

public interface SevenTerraceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenTerrace record);

    SevenTerrace selectByPrimaryKey(Integer id);

    List<SevenTerrace> selectAll();

    int updateByPrimaryKey(SevenTerrace record);

	List<SevenTerrace> getSevenTerraceList(@Param("tFid")Integer tFid, @Param("tName")String string);

	int changeState(@Param("id")Integer id,@Param("tState") Integer tState);
}