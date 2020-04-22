package com.ally.sevennoticefile.mapper;

import java.util.List;

import com.ally.sevennoticefile.bean.SevenNoticeFile;

public interface SevenNoticeFileMapper {
    int insert(SevenNoticeFile record);

    SevenNoticeFile selectByPrimaryKey(Integer id);

    List<SevenNoticeFile> selectAll();

}