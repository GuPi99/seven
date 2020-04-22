package com.ally.sevenreport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenreport.bean.SevenReport;

public interface SevenReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenReport record);

    SevenReport selectByPrimaryKey(Integer id);

    List<SevenReport> selectAll();

    int updateByPrimaryKey(SevenReport record);

	List<SevenReport> getSevenReportList(@Param("rSid")Integer rSid, @Param("rDate")String string,@Param("rTitle") String string2);

	int addIndicate(SevenReport sevenReport);

	int addReply(SevenReport sevenReport);

}