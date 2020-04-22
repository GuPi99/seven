package com.ally.sevendelivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevendelivery.bean.SevenDelivery;

public interface SevenDeliveryMapper {

    int insert(SevenDelivery record);

    SevenDelivery selectByPrimaryKey(Integer id);

    List<SevenDelivery> selectAll();

	int addBranch(SevenDelivery sevenDelivery);

	int addDirector(SevenDelivery sevenDelivery);

	int addManger(SevenDelivery sevenDelivery);

	List<SevenDelivery> getSevenDeliveryList(@Param("dSid")Integer dSid,@Param("applicationState")Integer applicationState, @Param("projectNum")String string, @Param("projectName")String string2, 
			@Param("applicationDate")String string3);
}