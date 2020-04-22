package com.ally.sevenrole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenrole.bean.SevenRole;

public interface SevenRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenRole record);

    SevenRole selectByPrimaryKey(Integer id);

    List<SevenRole> selectAll();

    int updateByPrimaryKey(SevenRole record);

	List<SevenRole> getSevenRoleList(@Param("rName")String rName);

	String selectName(Integer getaRid);
}