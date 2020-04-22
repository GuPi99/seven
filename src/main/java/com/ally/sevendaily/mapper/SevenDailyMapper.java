package com.ally.sevendaily.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevendaily.bean.SevenDaily;

public interface SevenDailyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenDaily record);

    SevenDaily selectByPrimaryKey(Integer id);

    List<SevenDaily> selectAll();

    int updateByPrimaryKey(SevenDaily record);

	List<SevenDaily> getSevenDailyList(@Param("dSid")Integer dSid,@Param("dType")Integer dType, @Param("dDate")String string);

	List<SevenDaily> getTrendList(Integer oSid);

}