package com.ally.sevenprint.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenprint.bean.SevenPrint;

public interface SevenPrintMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenPrint record);

    SevenPrint selectByPrimaryKey(Integer id);

    List<SevenPrint> selectAll();

    int updateByPrimaryKey(SevenPrint record);

	String selectUrl(@Param("id")Integer getaPid);

}