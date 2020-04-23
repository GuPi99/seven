package com.ally.sevenstaff.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenstaff.bean.SevenStaff;

public interface SevenStaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenStaff record);

    SevenStaff selectByPrimaryKey(Integer id);

    List<SevenStaff> selectAll();

    int updateByPrimaryKey(SevenStaff record);

	Integer getCount();

	int updateSevenStaffState(@Param("id")Integer id, @Param("sState")Integer sState);

	String selectName(Integer getaSid);

	List<SevenStaff> getSevenStaffList(@Param("sSex")Integer sSex, @Param("sName")String string,@Param("sDateBirth") String string2);

	List<SevenStaff> selectNoAccount();
}