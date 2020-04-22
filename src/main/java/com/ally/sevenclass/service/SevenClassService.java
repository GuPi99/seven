package com.ally.sevenclass.service;

import java.util.List;

import com.ally.sevenclass.bean.SevenClass;
import com.github.pagehelper.PageInfo;

public interface SevenClassService {

	Boolean addSevenClass(SevenClass sevenClass);

	Boolean deleteSevenClass(Integer id);

	SevenClass selectSevenClass(Integer id);

	Boolean updateSevenClass(SevenClass sevenClass);

	List<SevenClass> selectAll();

	PageInfo<SevenClass> getSevenClassList(Integer page, Integer limit,String cName);

	List<SevenClass> selectAllName();


}
