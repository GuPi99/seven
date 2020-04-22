package com.ally.sevenprojectfile.service;

import com.ally.sevenprojectfile.bean.SevenProjectFile;
import com.ally.sevenprojectgoods.bean.SevenProjectGoods;
import com.github.pagehelper.PageInfo;

public interface SevenProjectFileService {

	Boolean addSevenProjectFile(SevenProjectFile sevenProjectFile);

	Boolean deleteSevenProjectFile(Integer id);

	PageInfo<SevenProjectGoods> getSevenProjectFileList(Integer page, Integer limit, Integer pfPid);


}
