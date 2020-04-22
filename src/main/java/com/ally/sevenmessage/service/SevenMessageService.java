package com.ally.sevenmessage.service;

import java.util.List;

import com.ally.sevenmessage.bean.SevenMessage;
import com.github.pagehelper.PageInfo;

public interface SevenMessageService {

	Boolean addSevenMessage(SevenMessage sevenMessage);

	Boolean deleteSevenMessage(Integer id);

	Boolean updateSevenMessage(SevenMessage sevenMessage);

	SevenMessage selectSevenMessageById(Integer id);

	PageInfo<SevenMessage> getSevenMessageList(Integer page, Integer limit, String mName, Integer mType);

	List<SevenMessage> selectDepart();

	List<SevenMessage> selectPosition();

}
