package com.ally.sevennotice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevennotice.bean.SevenNotice;

public interface SevenNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenNotice record);

    SevenNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SevenNotice record);

	List<SevenNotice> getSevenNoticeList(@Param("title")String string);

	List<SevenNotice> getIndexList();

	Integer getIndexCount();
}