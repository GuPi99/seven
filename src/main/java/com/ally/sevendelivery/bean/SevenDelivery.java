package com.ally.sevendelivery.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenDelivery {
    private Integer id;

    private Integer dSid;

    private String projectNum;

    private String projectName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applicationDate;

    private Integer moneyState;

    private Integer applicationState;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dBranchTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dDirectorTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dManagerTime;

    private String dBranch;

    private String dDirector;

    private String dManager;
    
    private String staffName;
    
    private String nowState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getdSid() {
        return dSid;
    }

    public void setdSid(Integer dSid) {
        this.dSid = dSid;
    }

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum == null ? null : projectNum.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getMoneyState() {
        return moneyState;
    }

    public void setMoneyState(Integer moneyState) {
        this.moneyState = moneyState;
    }

    public Integer getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(Integer applicationState) {
        this.applicationState = applicationState;
    }

    public Date getdBranchTime() {
        return dBranchTime;
    }

    public void setdBranchTime(Date dBranchTime) {
        this.dBranchTime = dBranchTime;
    }

    public Date getdDirectorTime() {
        return dDirectorTime;
    }

    public void setdDirectorTime(Date dDirectorTime) {
        this.dDirectorTime = dDirectorTime;
    }

    public Date getdManagerTime() {
        return dManagerTime;
    }

    public void setdManagerTime(Date dManagerTime) {
        this.dManagerTime = dManagerTime;
    }

    public String getdBranch() {
        return dBranch;
    }

    public void setdBranch(String dBranch) {
        this.dBranch = dBranch == null ? null : dBranch.trim();
    }

    public String getdDirector() {
        return dDirector;
    }

    public void setdDirector(String dDirector) {
        this.dDirector = dDirector == null ? null : dDirector.trim();
    }

    public String getdManager() {
        return dManager;
    }

    public void setdManager(String dManager) {
        this.dManager = dManager == null ? null : dManager.trim();
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
    
    
}