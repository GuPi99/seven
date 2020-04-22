package com.ally.sevenproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.sevenProjectCheck.bean.SevenProjectCheck;
import com.ally.sevenProjectCheck.mapper.SevenProjectCheckMapper;
import com.ally.sevenfirm.mapper.SevenFirmMapper;
import com.ally.sevenproject.bean.SevenProject;
import com.ally.sevenproject.mapper.SevenProjectMapper;
import com.ally.sevenprojectbill.bean.SevenProjectBill;
import com.ally.sevenprojectbill.mapper.SevenProjectBillMapper;
import com.ally.sevenstaff.mapper.SevenStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SevenProjectServiceImpl implements SevenProjectService {

	@Autowired
	private SevenProjectMapper sevenProjectMapper;
	@Autowired
	private SevenStaffMapper sevenStaffMapper;
	@Autowired
	private SevenFirmMapper sevenFirmMapper;
	@Autowired
	private SevenProjectCheckMapper sevenProjectCheckMapper;
	@Autowired
	private SevenProjectBillMapper sevenProjectBillMapper;
	
	// 添加
	@Override
	public Boolean addSevenProject(SevenProject sevenProject) {
		// TODO Auto-generated method stub
		return sevenProjectMapper.insert(sevenProject) > 0;
	}

	// 查看
	@Override
	public SevenProject selectSevenProjectById(Integer id) {
		// TODO Auto-generated method stub
		SevenProject sevenProject = sevenProjectMapper.selectByPrimaryKey(id);
		sevenProject.setStaffName(sevenStaffMapper.selectName(sevenProject.getpSid()));
		sevenProject.setFirmName(sevenFirmMapper.selectName(sevenProject.getpFid()));
		return sevenProject;
	}

	@Override
	public PageInfo<SevenProject> getSevenProjectList(Integer pageNum, Integer pageSize, Integer pcState, Integer pFid,
			String pDate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenProject> list = sevenProjectMapper.getSevenProjectList(pcState,pFid,pDate);
		for (SevenProject sevenProject : list) {
			sevenProject.setFirmName(sevenFirmMapper.selectName(sevenProject.getpFid()));
			SevenProjectCheck sevenProjectCheck=sevenProjectCheckMapper.selectCheck(sevenProject.getId());
			if (sevenProjectCheck.getPcState()==0) {
				sevenProject.setNowState("未审批");
			} else if (sevenProjectCheck.getPcState()==1) {
				sevenProject.setNowState("部门审批通过");
			} else if (sevenProjectCheck.getPcState()==2) {
				sevenProject.setNowState("主管审批通过");
			} else if (sevenProjectCheck.getPcState()==3) {
				sevenProject.setNowState("经理审批通过");
			}else if (sevenProjectCheck.getPcState()==4) {
				sevenProject.setNowState("项目完结");
			} else if (sevenProjectCheck.getPcState()==-1) {
				sevenProject.setNowState("部门审批不通过");
			} else if (sevenProjectCheck.getPcState()==-2) {
				sevenProject.setNowState("主管审批不通过");
			} else if (sevenProjectCheck.getPcState()==-3) {
				sevenProject.setNowState("经理审批不通过");
			} else if (sevenProjectCheck.getPcState()==-4) {
				sevenProject.setNowState("项目作废");
			}
		}
		PageInfo<SevenProject> info=new PageInfo<>(list,10);
		return info;
	}

	@Override
	public PageInfo<SevenProject> getSevenProjectBillList(Integer pageNum, Integer pageSize, Integer pFid, String pDate,
			Integer pbState) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		List<SevenProject> list = sevenProjectMapper.getSevenProjectBillList(pFid,pDate,pbState);
		for (SevenProject sevenProject : list) {
			sevenProject.setFirmName(sevenFirmMapper.selectName(sevenProject.getpFid()));
			SevenProjectBill sevenProjectBill=sevenProjectBillMapper.selectSevenProjectBill(sevenProject.getId());
			if (sevenProjectBill.getPbState()==0) {
				sevenProject.setNowState("未审批");
			} else if (sevenProjectBill.getPbState()==1) {
				sevenProject.setNowState("部门审批通过");
			} else if (sevenProjectBill.getPbState()==2) {
				sevenProject.setNowState("主管审批通过");
			} else if (sevenProjectBill.getPbState()==3) {
				sevenProject.setNowState("经理审批通过");
			} else if (sevenProjectBill.getPbState()==-1) {
				sevenProject.setNowState("部门审批不通过");
			} else if (sevenProjectBill.getPbState()==-2) {
				sevenProject.setNowState("主管审批不通过");
			} else if (sevenProjectBill.getPbState()==-3) {
				sevenProject.setNowState("经理审批不通过");
			}
		}
		PageInfo<SevenProject> info=new PageInfo<>(list,10);
		return info;
	}

}
