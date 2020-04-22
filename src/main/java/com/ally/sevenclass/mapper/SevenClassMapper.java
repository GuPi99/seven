package com.ally.sevenclass.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenclass.bean.SevenClass;

public interface SevenClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenClass record);

    SevenClass selectByPrimaryKey(Integer id);

    List<SevenClass> selectAll();

    int updateByPrimaryKey(SevenClass record);

	String selectName(Integer pgCid);

	List<SevenClass> getSevenClassList(@Param("cName")String string);

	List<SevenClass> selectAllName();

}