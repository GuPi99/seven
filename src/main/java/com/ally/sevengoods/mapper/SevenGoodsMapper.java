package com.ally.sevengoods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevengoods.bean.SevenGoods;

public interface SevenGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenGoods record);

    SevenGoods selectByPrimaryKey(Integer id);

    List<SevenGoods> selectAll();

    int updateByPrimaryKey(SevenGoods record);

	List<SevenGoods> getSevenGoodsList(@Param("gCid")Integer gCid,@Param("gName") String gName);

	List<SevenGoods> selectAllName();

	Integer batchAddition(List<SevenGoods> list);

	List<SevenGoods> selectUnder(@Param("id")Integer id);

	List<SevenGoods> selectGoods(@Param("id")Integer id);

	String selectName(@Param("productId")Integer productId);

}