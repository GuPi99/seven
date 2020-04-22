package com.ally.sevendelivery.service;

import com.ally.sevendelivery.bean.SevenDelivery;
import com.github.pagehelper.PageInfo;

public interface SevenDeliveryService {

	Boolean addSevenDelivery(SevenDelivery sevenDelivery);

	Boolean addBranch(SevenDelivery sevenDelivery);

	Boolean addDirector(SevenDelivery sevenDelivery);

	Boolean addManger(SevenDelivery sevenDelivery);

	SevenDelivery selectSevenDelivery(Integer id);

	PageInfo<SevenDelivery> getSevenDeliveryList(Integer page, Integer limit, Integer dSid,Integer applicationState, String projectNum,
			String projectName,  String applicationDate);

}
