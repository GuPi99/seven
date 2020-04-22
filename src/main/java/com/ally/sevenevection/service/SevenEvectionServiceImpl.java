package com.ally.sevenevection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenevection.bean.SevenEvection;
import com.ally.sevenevection.mapper.SevenEvectionMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenEvectionServiceImpl implements SevenEvectionService {

	@Autowired
	private SevenEvectionMapper sevenEvectionMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	
	//添加
	@Override
	public Boolean addSevenVacate(SevenEvection sevenEvection) {
		// TODO Auto-generated method stub
		return sevenEvectionMapper.insert(sevenEvection)>0;
	}

	//添加部门审批
	@Override
	public Boolean addBranch(SevenEvection sevenEvection) {
		// TODO Auto-generated method stub
		return sevenEvectionMapper.addBranch(sevenEvection)>0;
	}

	//主管审批
	@Override
	public Boolean addDirector(SevenEvection sevenEvection) {
		// TODO Auto-generated method stub
		return sevenEvectionMapper.addDirector(sevenEvection)>0;
	}

	//经理审批
	@Override
	public Boolean addManger(SevenEvection sevenEvection) {
		// TODO Auto-generated method stub
		return sevenEvectionMapper.addManger(sevenEvection)>0;
	}

	@Override
	public SevenEvection selectSevenEvection(Integer id) {
		// TODO Auto-generated method stub
		return sevenEvectionMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SevenEvection> getSevenEvectionList(Integer pageNum, Integer pageSize, Integer eSid, Integer eState,
			String eGoal, String eApplyTime) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<SevenEvection> list = sevenEvectionMapper.getSevenEvectionList(eSid,eState,"%"+eGoal+"%","%"+eApplyTime+"%");
		for (SevenEvection sevenEvection : list) {
			sevenEvection.setStaffName(sevenStaffMapper.selectName(sevenEvection.geteSid()));
			if (sevenEvection.geteState()==0) {
				sevenEvection.setNowState("未审批");
			} else if (sevenEvection.geteState()==1) {
				sevenEvection.setNowState("部门审批通过");
			} else if (sevenEvection.geteState()==2) {
				sevenEvection.setNowState("主管审批通过");
			} else if (sevenEvection.geteState()==3) {
				sevenEvection.setNowState("经理审批通过");
			} else if (sevenEvection.geteState()==-1) {
				sevenEvection.setNowState("部门审批不通过");
			} else if (sevenEvection.geteState()==-2) {
				sevenEvection.setNowState("主管审批不通过");
			} else if (sevenEvection.geteState()==-3) {
				sevenEvection.setNowState("经理审批不通过");
			}
		}
		PageInfo<SevenEvection> info = new PageInfo<>(list, 10);
		return info;
	}

	@Override
	public List<SevenEvection> getIndexList(Integer getaSid, String now, String after) {
		// TODO Auto-generated method stub
		return sevenEvectionMapper.getIndexList(getaSid,now,after);
	}

}
