package com.ally.sevenbank.service;

import java.util.List;

import com.ally.sevenbank.bean.SevenBank;
import com.github.pagehelper.PageInfo;

public interface SevenBankService {

	Boolean addSevenBank(SevenBank sevenBank);

	Boolean deleteSevenBank(Integer id);

	SevenBank selectSevenBank(Integer id);

	Boolean updateSevenBank(SevenBank sevenBank);

	PageInfo<SevenBank> getSevenBankList(Integer page, Integer limit, String bName);

	List<SevenBank> seltceAll();

}
