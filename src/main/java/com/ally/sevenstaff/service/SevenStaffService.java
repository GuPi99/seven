package com.ally.sevenstaff.service;

import java.util.List;

import com.ally.sevenstaff.bean.SevenStaff;
import com.github.pagehelper.PageInfo;

public interface SevenStaffService {

	Boolean addSevenStaff(SevenStaff sevenStaff);

	Boolean deleteSevenStaff(Integer id);

	Boolean updateSevenStaff(SevenStaff sevenStaff);

	SevenStaff selectSevenStaffById(Integer id);

	Boolean updateSevenStaffState(Integer id, Integer sState);

	List<SevenStaff> selectAll();

	PageInfo<SevenStaff> getSevenStaffList(Integer page, Integer limit, Integer sSex, String sName, String sDateBirth);

	List<SevenStaff> selectNoAccount();

}
