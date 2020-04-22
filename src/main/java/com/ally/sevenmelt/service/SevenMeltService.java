package com.ally.sevenmelt.service;

import com.ally.sevenmelt.bean.SevenMelt;
import com.github.pagehelper.PageInfo;

public interface SevenMeltService {

	Boolean addSevenMelt(SevenMelt sevenMelt);

	Boolean addBranch(SevenMelt sevenMelt);

	Boolean addDirector(SevenMelt sevenMelt);

	Boolean addManger(SevenMelt sevenMelt);

	SevenMelt selectSevenMelt(Integer id);

	PageInfo<SevenMelt> getSevenMeltList(Integer page, Integer limit, Integer mSid, Integer mState, String mApplyTime,
			String mItems);

}
