package com.ally.sevenprojectbill.service;

import com.ally.sevenprojectbill.bean.SevenProjectBill;

public interface SevenProjectBillService {

	SevenProjectBill selectSevenProjectBill(Integer pbPid);

	Boolean addSevenProjectBill(SevenProjectBill sevenProjectBill);

	Boolean addBranch(SevenProjectBill sevenProjectBill);

	Boolean addDirector(SevenProjectBill sevenProjectBill);

	Boolean addManger(SevenProjectBill sevenProjectBill);

}
