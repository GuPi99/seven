package com.ally.sevenvisit.service;

import com.ally.sevenvisit.bean.SevenVisit;
import com.github.pagehelper.PageInfo;

public interface SevenVisitService {

	PageInfo<SevenVisit> getSevenVisitList(Integer page, Integer limit, Integer vEid);

	Boolean deleteSevenVisit(Integer id);

	Boolean addSevenVisit(SevenVisit sevenVisit);

}
