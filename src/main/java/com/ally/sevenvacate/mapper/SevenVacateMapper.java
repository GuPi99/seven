package com.ally.sevenvacate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenvacate.bean.SevenVacate;

public interface SevenVacateMapper {
    int insert(SevenVacate record);

    SevenVacate selectByPrimaryKey(Integer id);

	List<SevenVacate> getSevenVacatetList(@Param("vSid")Integer vSid, @Param("vSate")Integer vSate, @Param("vStart")String string, @Param("vEnd")String string2);

	int addBranch(SevenVacate sevenVacate);

	int addDirector(SevenVacate sevenVacate);

	int addManger(SevenVacate sevenVacate);
}