package com.ally.sevenlog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenlog.bean.SevenLog;

public interface SevenLogMapper {
    int insert(SevenLog record);

	List<SevenLog> getSevenLogList(@Param("lDatetime")String lDatetime);

	List<SevenLog> getSevenLogSelfList(@Param("lAid")Integer lAid,@Param("lDatetime") String string);
}