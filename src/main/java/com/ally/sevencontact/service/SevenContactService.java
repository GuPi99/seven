package com.ally.sevencontact.service;

import java.util.List;

import com.ally.sevencontact.bean.SevenContact;
import com.github.pagehelper.PageInfo;

public interface SevenContactService {

	Boolean addSevenContact(SevenContact sevenContact);

	Boolean deleteSevenContact(Integer id);

	Boolean updateSevenContact(SevenContact sevenContact);

	SevenContact selectSevenContact(Integer id);

	PageInfo<SevenContact> getSevenContactList(Integer page, Integer limit, Integer cFid, String cName);

	Boolean changeState(Integer id, Integer cState);

	List<SevenContact> selectContactList(Integer id);

}
