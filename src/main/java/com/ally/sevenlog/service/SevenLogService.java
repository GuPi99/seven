package com.ally.sevenlog.service;

import com.ally.sevenlog.bean.SevenLog;
import com.github.pagehelper.PageInfo;

public interface SevenLogService {

	void insertLog(SevenLog logInfo);

	PageInfo<SevenLog> getSevenLogList(Integer page, Integer limit, String lDatetime);

	PageInfo<SevenLog> getSevenLogSelfList(Integer page, Integer limit, Integer lAid, String lDatetime);

}
