package com.ally.sevenevection.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenEvection {
	private Integer id;

	private Integer eSid;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date eApplyTime;

	private Integer eState;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date eBranchTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date eDirectorTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date eManagerTime;

	private String eGoal;

	private String eBranch;

	private String eDirector;
	
	private String eManager;

	private String staffName;

	private String nowState;
	
	private String eText;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date estimatedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer geteSid() {
		return eSid;
	}

	public void seteSid(Integer eSid) {
		this.eSid = eSid;
	}

	public Date geteApplyTime() {
		return eApplyTime;
	}

	public void seteApplyTime(Date eApplyTime) {
		this.eApplyTime = eApplyTime;
	}

	public Integer geteState() {
		return eState;
	}

	public void seteState(Integer eState) {
		this.eState = eState;
	}

	public Date geteBranchTime() {
		return eBranchTime;
	}

	public void seteBranchTime(Date eBranchTime) {
		this.eBranchTime = eBranchTime;
	}

	public Date geteDirectorTime() {
		return eDirectorTime;
	}

	public void seteDirectorTime(Date eDirectorTime) {
		this.eDirectorTime = eDirectorTime;
	}

	public String geteManager() {
		return eManager;
	}

	public void seteManager(String eManager) {
		this.eManager = eManager;
	}

	public Date geteManagerTime() {
		return eManagerTime;
	}

	public void seteManagerTime(Date eManagerTime) {
		this.eManagerTime = eManagerTime;
	}

	public String geteGoal() {
		return eGoal;
	}

	public void seteGoal(String eGoal) {
		this.eGoal = eGoal == null ? null : eGoal.trim();
	}

	public String geteBranch() {
		return eBranch;
	}

	public void seteBranch(String eBranch) {
		this.eBranch = eBranch == null ? null : eBranch.trim();
	}

	public String geteDirector() {
		return eDirector;
	}

	public void seteDirector(String eDirector) {
		this.eDirector = eDirector == null ? null : eDirector.trim();
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getNowState() {
		return nowState;
	}

	public void setNowState(String nowState) {
		this.nowState = nowState;
	}

	public String geteText() {
		return eText;
	}

	public void seteText(String eText) {
		this.eText = eText;
	}

	public Date getEstimatedDate() {
		return estimatedDate;
	}

	public void setEstimatedDate(Date estimatedDate) {
		this.estimatedDate = estimatedDate;
	}

	
}