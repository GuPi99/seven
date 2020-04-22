package com.ally.sevenbusinessfile.mapper;

import java.util.List;

import com.ally.sevenbusinessfile.bean.SevenBusinessFile;

public interface SevenBusinessFileMapper {
    int insert(SevenBusinessFile record);

    SevenBusinessFile selectByPrimaryKey(Integer id);

    List<SevenBusinessFile> selectAll();

}