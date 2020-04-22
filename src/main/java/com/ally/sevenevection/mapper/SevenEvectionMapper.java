package com.ally.sevenevection.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenevection.bean.SevenEvection;

public interface SevenEvectionMapper {
    int insert(SevenEvection record);

    SevenEvection selectByPrimaryKey(Integer id);

	int addBranch(SevenEvection sevenEvection);

	int addDirector(SevenEvection sevenEvection);

	int addManger(SevenEvection sevenEvection);

	List<SevenEvection> getSevenEvectionList(@Param("eSid")Integer eSid, @Param("eState")Integer eState,@Param("eGoal") String string, @Param("eApplyTime")String string2);

	List<SevenEvection> getIndexList(@Param("eSid")Integer getaSid, @Param("now")String now, @Param("after")String after);
}