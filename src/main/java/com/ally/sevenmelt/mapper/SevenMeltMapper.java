package com.ally.sevenmelt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenmelt.bean.SevenMelt;

public interface SevenMeltMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenMelt record);

    SevenMelt selectByPrimaryKey(Integer id);

    List<SevenMelt> selectAll();

    int updateByPrimaryKey(SevenMelt record);

	int addBranch(SevenMelt sevenMelt);

	int addDirector(SevenMelt sevenMelt);

	int addManger(SevenMelt sevenMelt);

	List<SevenMelt> getSevenMeltList(@Param("mSid")Integer mSid, @Param("mState")Integer mState, @Param("mApplyTime")String string, @Param("mItems")String string2);
}