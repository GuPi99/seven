package com.ally.sevencontact.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevencontact.bean.SevenContact;

public interface SevenContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenContact record);

    SevenContact selectByPrimaryKey(Integer id);

    List<SevenContact> selectAll();

    int updateByPrimaryKey(SevenContact record);

	List<SevenContact> getSevenContactList(@Param("cFid")Integer cFid,@Param("cName") String string);

	int changeState(@Param("id")Integer id,@Param("cState") Integer cState);

	List<SevenContact> selectContactList(@Param("id")Integer id);

}