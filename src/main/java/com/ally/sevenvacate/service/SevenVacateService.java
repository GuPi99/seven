package com.ally.sevenvacate.service;

import com.ally.sevenvacate.bean.SevenVacate;
import com.github.pagehelper.PageInfo;

public interface SevenVacateService {

	Boolean addSevenVacate(com.ally.sevenvacate.bean.SevenVacate sevenVacate);

	SevenVacate selectSevenVacate(Integer id);

	PageInfo<SevenVacate> getSevenVacatetList(Integer page, Integer limit, Integer vSid, Integer vSate,
			String vStart, String vEnd);

	Boolean addBranch(SevenVacate sevenVacate);

	Boolean addDirector(SevenVacate sevenVacate);

	Boolean addManger(SevenVacate sevenVacate);

}
