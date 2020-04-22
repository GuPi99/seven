package com.ally.sevengoods.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevengoods.bean.SevenGoods;
import com.github.pagehelper.PageInfo;

public interface SevenGoodsService {

	Boolean addSevenGoods(SevenGoods sevenGoods);

	Boolean deleteSevenGoods(Integer id);

	SevenGoods selectSevenGoods(Integer id);

	Boolean updateSevenGoods(SevenGoods sevenGoods);

	PageInfo<SevenGoods> getSevenGoodsList(Integer page, Integer limit, Integer gCid, String gName);

	List<SevenGoods> selectAll();

	List<SevenGoods> selectAllName();

	Boolean batchAddition(List<SevenGoods> list);

	List<SevenGoods> selectUnder(Integer id);

	List<SevenGoods> selectGoods(@Param("id")Integer id);

	PageInfo<SevenGoods> getProjectGoodsList(Integer page, Integer limit, Integer id);

}
