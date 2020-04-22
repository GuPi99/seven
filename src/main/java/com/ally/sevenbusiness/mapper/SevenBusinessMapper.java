package com.ally.sevenbusiness.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenbusiness.bean.SevenBusiness;

public interface SevenBusinessMapper {
    int insert(SevenBusiness record);

    SevenBusiness selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SevenBusiness record);

	List<SevenBusiness> getIndexList(@Param("staffId")Integer staffId);

	Integer getIndexCount(@Param("staffId")Integer staffId);

	int updateReadStatus(@Param("id")Integer id);

	List<SevenBusiness> getSevenBusinessList(@Param("title")String title,  @Param("staffId")Integer getaSid);
}