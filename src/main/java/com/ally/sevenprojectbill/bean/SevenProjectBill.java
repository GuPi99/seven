package com.ally.sevenprojectbill.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenProjectBill {
    private Integer id;

    private Integer pbPid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pbTime;

    private Integer pbState;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pbBranchTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pbDirectorTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pbManagerTime;

    private String pbBranch;

    private String pbDirector;

    private String pbManager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPbPid() {
        return pbPid;
    }

    public void setPbPid(Integer pbPid) {
        this.pbPid = pbPid;
    }

    public Date getPbTime() {
        return pbTime;
    }

    public void setPbTime(Date pbTime) {
        this.pbTime = pbTime;
    }

    public Integer getPbState() {
        return pbState;
    }

    public void setPbState(Integer pbState) {
        this.pbState = pbState;
    }

    public Date getPbBranchTime() {
        return pbBranchTime;
    }

    public void setPbBranchTime(Date pbBranchTime) {
        this.pbBranchTime = pbBranchTime;
    }

    public Date getPbDirectorTime() {
        return pbDirectorTime;
    }

    public void setPbDirectorTime(Date pbDirectorTime) {
        this.pbDirectorTime = pbDirectorTime;
    }

    public Date getPbManagerTime() {
        return pbManagerTime;
    }

    public void setPbManagerTime(Date pbManagerTime) {
        this.pbManagerTime = pbManagerTime;
    }

    public String getPbBranch() {
        return pbBranch;
    }

    public void setPbBranch(String pbBranch) {
        this.pbBranch = pbBranch == null ? null : pbBranch.trim();
    }

    public String getPbDirector() {
        return pbDirector;
    }

    public void setPbDirector(String pbDirector) {
        this.pbDirector = pbDirector == null ? null : pbDirector.trim();
    }

    public String getPbManager() {
        return pbManager;
    }

    public void setPbManager(String pbManager) {
        this.pbManager = pbManager == null ? null : pbManager.trim();
    }
}