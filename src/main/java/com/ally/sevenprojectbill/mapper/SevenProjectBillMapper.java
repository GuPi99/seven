package com.ally.sevenprojectbill.mapper;


import org.apache.ibatis.annotations.Param;

import com.ally.sevenprojectbill.bean.SevenProjectBill;

public interface SevenProjectBillMapper {
    int insert(SevenProjectBill record);

    int updateByPrimaryKey(SevenProjectBill record);

	SevenProjectBill selectSevenProjectBill(@Param("pbPid")Integer pbPid);

	int addBranch(SevenProjectBill sevenProjectBill);

	int addDirector(SevenProjectBill sevenProjectBill);

	int addManger(SevenProjectBill sevenProjectBill);

}