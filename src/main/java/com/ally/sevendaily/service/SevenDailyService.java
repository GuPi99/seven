package com.ally.sevendaily.service;

import com.ally.sevendaily.bean.SevenDaily;
import com.github.pagehelper.PageInfo;

public interface SevenDailyService {

	Boolean addSvenDaily(SevenDaily sevenDaily);

	Boolean deleteSevenDaily(Integer id);

	Boolean updateSevenDaily(SevenDaily sevenDaily);

	SevenDaily selectSevenDailyById(Integer id);

	PageInfo<SevenDaily> getTrendList(Integer page, Integer limit, Integer oSid);

	PageInfo<SevenDaily> getDayDailyList(Integer page, Integer limit, Integer dSid, String dDate);

}
