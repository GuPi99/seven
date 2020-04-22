package com.ally.sevenrole.service;

import java.util.List;

import com.ally.sevenrole.bean.SevenRole;
import com.github.pagehelper.PageInfo;

public interface SevenRoleService {

	PageInfo<SevenRole> getSevenRoleList(Integer page, Integer limit, String rName);

	Boolean addSevenRole(SevenRole sevenRole);

	SevenRole selectSevenRoleById(Integer id);

	Boolean deleteSevenRole(Integer id);

	Boolean updateSevenRole(SevenRole sevenRole);

	List<SevenRole> selectAllRole();

}
