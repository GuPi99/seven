package com.ally.sevenprojectgoods.service;

import com.ally.sevenprojectgoods.bean.SevenProjectGoods;
import com.github.pagehelper.PageInfo;

public interface SevenProjectGoodsService {

	Boolean addSevenProjectGoods(SevenProjectGoods sevenProjectGoods);

	Boolean delectProjectGoods(Integer id);

	PageInfo<SevenProjectGoods> getSevenProjectGoodsList(Integer page, Integer limit, Integer pgPid);

}
