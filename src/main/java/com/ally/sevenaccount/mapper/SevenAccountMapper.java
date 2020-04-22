package com.ally.sevenaccount.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenaccount.bean.SevenAccount;

public interface SevenAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenAccount record);

    SevenAccount selectByPrimaryKey(Integer id);

    List<SevenAccount> selectAll();

    int updateByPrimaryKey(SevenAccount record);

	int updateSevenAccountState(@Param("id")Integer id, @Param("aState")Integer aState);

	List<SevenAccount> getSevenAccountList(@Param("aAccount")String aAccount);

	String checkName(String aAccount);

	SevenAccount login(@Param("aAccount")String aAccount, @Param("aPassword")String md5Pwd);

	int updateNowSevenAccount(SevenAccount sevenAccount);

	List<SevenAccount> selectOtherAccount(@Param("id")Integer id);

	Boolean updatePassword(@Param("paws")String paws, @Param("id")Integer id);
}