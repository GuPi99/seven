package com.ally.sevenmessage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenmessage.bean.SevenMessage;

public interface SevenMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenMessage record);

    SevenMessage selectByPrimaryKey(Integer id);

    List<SevenMessage> selectAll();

    int updateByPrimaryKey(SevenMessage record);

	List<SevenMessage> getSevenMessageList(@Param("mName")String mName, @Param("mType")Integer mType);

	String selectName(Integer id);

	List<SevenMessage> selectDepart();

	List<SevenMessage> selectPosition();

}