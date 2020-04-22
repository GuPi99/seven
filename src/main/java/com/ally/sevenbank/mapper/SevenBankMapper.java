package com.ally.sevenbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenbank.bean.SevenBank;

public interface SevenBankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenBank record);

    SevenBank selectByPrimaryKey(Integer id);

    List<SevenBank> selectAll();

    int updateByPrimaryKey(SevenBank record);
    
	List<SevenBank> getSevenBankList(@Param("bName")String bName);
}