package com.ally.sevenbankaccount.service;

import java.util.List;

import com.ally.sevenbankaccount.bean.SevenBankAccount;
import com.github.pagehelper.PageInfo;

public interface SevenBankAccountService {

	Boolean addSevenBankAccount(SevenBankAccount sevenBankAccount);

	Boolean deleteSevenBankAccount(Integer id);

	Boolean updateSevenBankAccount(SevenBankAccount sevenBankAccount);

	SevenBankAccount selectSevenBankAccountById(Integer id);

	PageInfo<SevenBankAccount> getSevenBankAccountList(Integer page, Integer limit, Integer baFid, Integer baBid);

	List<SevenBankAccount> seltceAll();


}
