package com.ally.sevenvisit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenvisit.bean.SevenVisit;

public interface SevenVisitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenVisit record);

    SevenVisit selectByPrimaryKey(Integer id);

    List<SevenVisit> selectAll();

    int updateByPrimaryKey(SevenVisit record);

	List<SevenVisit> getSevenVisitList(@Param("vEid")Integer vEid);
}