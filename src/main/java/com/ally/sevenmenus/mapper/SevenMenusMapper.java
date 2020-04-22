package com.ally.sevenmenus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenmenus.bean.SevenMenus;

public interface SevenMenusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenMenus record);

    SevenMenus selectByPrimaryKey(Integer id);

    List<SevenMenus> selectAll();

    int updateByPrimaryKey(SevenMenus record);

	List<SevenMenus> getSevenMenusList(@Param("mMid")Integer mMid,@Param("mName") String mName);

	int updateState(@Param("id")Integer id, @Param("mState")Integer mState);

	List<SevenMenus> selectMenus(int i);
	
	List<SevenMenus> selectRolePermissions(String[] split);

}