package com.ally.sevenbankaccount.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenbankaccount.bean.SevenBankAccount;

public interface SevenBankAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenBankAccount record);

    SevenBankAccount selectByPrimaryKey(Integer id);

    List<SevenBankAccount> selectAll();

    int updateByPrimaryKey(SevenBankAccount record);

	List<SevenBankAccount> getSevenBankAccountList(@Param("baFid")Integer baFid, @Param("baBid")Integer baBid);

}