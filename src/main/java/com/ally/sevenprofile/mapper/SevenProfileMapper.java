package com.ally.sevenprofile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenprofile.bean.SevenProfile;

public interface SevenProfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenProfile record);

    SevenProfile selectByPrimaryKey(Integer id);

    List<SevenProfile> selectAll();

    int updateByPrimaryKey(SevenProfile record);

	List<SevenProfile> getSevenProfileList(@Param("pFid")Integer pFid);
}