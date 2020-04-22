package com.ally.sevenprojectgoods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenprojectgoods.bean.SevenProjectGoods;

public interface SevenProjectGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenProjectGoods record);

    SevenProjectGoods selectByPrimaryKey(Integer id);

	List<SevenProjectGoods> getSevenProjectGoodsList(@Param("pgPid")Integer pgPid);

}