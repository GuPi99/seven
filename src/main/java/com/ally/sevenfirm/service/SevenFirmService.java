package com.ally.sevenfirm.service;

import java.util.List;

import com.ally.sevenfirm.bean.SevenFirm;
import com.github.pagehelper.PageInfo;

public interface SevenFirmService {

	Boolean addSevenFirm(SevenFirm sevenFirm);

	Boolean deleteSevenFirm(Integer id);

	SevenFirm selectSevenFirm(Integer id);

	Boolean updateSevenFirm(SevenFirm sevenFirm);

	List<SevenFirm> selectAll();

	PageInfo<SevenFirm> getSevenFirmList(Integer page, Integer limit, String fName);

	List<SevenFirm> selectUnderFirm(Integer id);

	Boolean batchFirm(List<SevenFirm> list);


}
