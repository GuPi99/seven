package com.ally.sevenprojectbill.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenprojectbill.bean.SevenProjectBill;
import com.ally.sevenprojectbill.mapper.SevenProjectBillMapper;

@Service
public class SevenProjectBillServiceImpl implements SevenProjectBillService {

	@Autowired
	private SevenProjectBillMapper sevenProjectBillMapper;
	
	@Override
	public SevenProjectBill selectSevenProjectBill(Integer pbPid) {
		// TODO Auto-generated method stub
		return sevenProjectBillMapper.selectSevenProjectBill(pbPid);
	}

	@Override
	public Boolean addSevenProjectBill(SevenProjectBill sevenProjectBill) {
		// TODO Auto-generated method stub
		return sevenProjectBillMapper.insert(sevenProjectBill)>0;
	}

	@Override
	public Boolean addBranch(SevenProjectBill sevenProjectBill) {
		// TODO Auto-generated method stub
		return sevenProjectBillMapper.addBranch(sevenProjectBill)>0;
	}

	@Override
	public Boolean addDirector(SevenProjectBill sevenProjectBill) {
		// TODO Auto-generated method stub
		return sevenProjectBillMapper.addDirector(sevenProjectBill)>0;
	}

	@Override
	public Boolean addManger(SevenProjectBill sevenProjectBill) {
		// TODO Auto-generated method stub
		return sevenProjectBillMapper.addManger(sevenProjectBill)>0;
	}

}
