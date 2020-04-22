package com.ally.sevennotice.service;

import java.util.List;

import com.ally.sevennotice.bean.SevenNotice;
import com.github.pagehelper.PageInfo;

public interface SevenNoticeSerivce {

	Boolean addSevenNotice(SevenNotice sevenNotice);

	PageInfo<SevenNotice> getSevenNoticeList(Integer page, Integer limit, String title);

	List<SevenNotice> getIndexList();

}
