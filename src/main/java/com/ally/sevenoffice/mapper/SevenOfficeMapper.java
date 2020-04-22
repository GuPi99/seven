package com.ally.sevenoffice.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenoffice.bean.SevenOffice;

public interface SevenOfficeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenOffice record);

    List<SevenOffice> selectAll();

    int updateByPrimaryKey(SevenOffice record);

	List<SevenOffice> getSevenOfficeList(Integer oSid);

	SevenOffice selectBefore(Integer oSid);

	int updateBeforeOffice(@Param("id")Integer id, @Param("oOffice")Date oOffice);
}