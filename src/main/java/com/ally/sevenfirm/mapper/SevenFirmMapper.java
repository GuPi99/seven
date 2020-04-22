package com.ally.sevenfirm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenfirm.bean.SevenFirm;

public interface SevenFirmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenFirm record);

    SevenFirm selectByPrimaryKey(Integer id);

    List<SevenFirm> selectAll();

    int updateByPrimaryKey(SevenFirm record);

	Integer getCount();

	String selectName(Integer getpFid);

	List<SevenFirm> getSevenFirmList(@Param("fName")String string);

	List<SevenFirm> selectUnderFirm(@Param("id")Integer id);

	int batchFirm(List<SevenFirm> list);
}