package com.ally.sevenprofile.service;

import com.ally.sevenprofile.bean.SevenProfile;
import com.github.pagehelper.PageInfo;

public interface SevenProfileService {

	Boolean addSevenProfile(SevenProfile sevenProfile);

	Boolean deleteSevenProfile(Integer id);

	Boolean updateSevenProfile(SevenProfile sevenProfile);

	SevenProfile selectSevenProfile(Integer id);

	PageInfo<SevenProfile> getSevenProfileList(Integer page, Integer limit, Integer pFid);

}
