package com.ally.sevenaccount.service;

import java.util.List;

import com.ally.sevenaccount.bean.SevenAccount;
import com.github.pagehelper.PageInfo;

public interface SevenAccountService {

	Boolean addSevenAccount(SevenAccount sevenAccount);

	Boolean deleteSevenAccount(Integer id);

	SevenAccount selectSevenAccount(Integer id);

	Boolean updateSevenAccount(SevenAccount sevenAccount);

	List<SevenAccount> selectAll();

	Boolean updateSevenAccountState(Integer id, Integer aState);

	PageInfo<SevenAccount> getSevenAccountList(Integer page, Integer limit, String aAccount);

	String checkName(String aAccount);

	SevenAccount login(String aAccount, String md5Pwd);

	Boolean updateNowSevenAccount(SevenAccount sevenAccount);

	List<SevenAccount> selectOtherAccount(Integer id);

	Boolean updatePassword(String paws, Integer id);

}
