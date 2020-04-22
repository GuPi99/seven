package com.ally.sevenmelt.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenMelt {
    private Integer id;

    private Integer mSid;

    private String mItems;

    private String mFigure;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mApplyTime;

    private Integer mState;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mBranchTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mDirectorTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mManagerTime;

    private String mDescribe;

    private String mBranch;

    private String mDirector;

    private String mManager;
    
    private String staffName;
    
    private String nowState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmSid() {
        return mSid;
    }

    public void setmSid(Integer mSid) {
        this.mSid = mSid;
    }

    public String getmItems() {
        return mItems;
    }

    public void setmItems(String mItems) {
        this.mItems = mItems == null ? null : mItems.trim();
    }

    public String getmFigure() {
        return mFigure;
    }

    public void setmFigure(String mFigure) {
        this.mFigure = mFigure == null ? null : mFigure.trim();
    }

    public Date getmApplyTime() {
        return mApplyTime;
    }

    public void setmApplyTime(Date mApplyTime) {
        this.mApplyTime = mApplyTime;
    }

    public Integer getmState() {
        return mState;
    }

    public void setmState(Integer mState) {
        this.mState = mState;
    }

    public Date getmBranchTime() {
        return mBranchTime;
    }

    public void setmBranchTime(Date mBranchTime) {
        this.mBranchTime = mBranchTime;
    }

    public Date getmDirectorTime() {
        return mDirectorTime;
    }

    public void setmDirectorTime(Date mDirectorTime) {
        this.mDirectorTime = mDirectorTime;
    }

    public Date getmManagerTime() {
        return mManagerTime;
    }

    public void setmManagerTime(Date mManagerTime) {
        this.mManagerTime = mManagerTime;
    }

    public String getmDescribe() {
        return mDescribe;
    }

    public void setmDescribe(String mDescribe) {
        this.mDescribe = mDescribe == null ? null : mDescribe.trim();
    }

    public String getmBranch() {
        return mBranch;
    }

    public void setmBranch(String mBranch) {
        this.mBranch = mBranch == null ? null : mBranch.trim();
    }

    public String getmDirector() {
        return mDirector;
    }

    public void setmDirector(String mDirector) {
        this.mDirector = mDirector == null ? null : mDirector.trim();
    }

    public String getmManager() {
        return mManager;
    }

    public void setmManager(String mManager) {
        this.mManager = mManager == null ? null : mManager.trim();
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