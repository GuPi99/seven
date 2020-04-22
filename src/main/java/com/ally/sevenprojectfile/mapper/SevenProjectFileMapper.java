package com.ally.sevenprojectfile.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ally.sevenprojectfile.bean.SevenProjectFile;
import com.ally.sevenprojectgoods.bean.SevenProjectGoods;

public interface SevenProjectFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SevenProjectFile record);

    SevenProjectFile selectByPrimaryKey(Integer id);

    List<SevenProjectFile> selectAll();

    int updateByPrimaryKey(SevenProjectFile record);

	List<SevenProjectGoods> getSevenProjectFileList(@Param("pfPid")Integer pfPid);
}