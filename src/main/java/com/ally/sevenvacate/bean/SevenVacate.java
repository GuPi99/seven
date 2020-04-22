package com.ally.sevenvacate.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenVacate {
    private Integer id;

    private Integer vSid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date vStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date vEnd;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date vApplyTime;

    private Integer vSate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date vBranchTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date vDirectorTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date vManagerTime;

    private String vReason;

    private String vBranch;

    private String vDirector;

    private String vManager;
    
    private String staffName;
    
    private String nowState;
    
    private String vUrl;
    
    private String vFileName;
    
    private String vType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getvSid() {
        return vSid;
    }

    public void setvSid(Integer vSid) {
        this.vSid = vSid;
    }

    public Date getvStart() {
        return vStart;
    }

    public void setvStart(Date vStart) {
        this.vStart = vStart;
    }

    public Date getvEnd() {
        return vEnd;
    }

    public void setvEnd(Date vEnd) {
        this.vEnd = vEnd;
    }

    public Date getvApplyTime() {
        return vApplyTime;
    }

    public void setvApplyTime(Date vApplyTime) {
        this.vApplyTime = vApplyTime;
    }

    public Integer getvSate() {
        return vSate;
    }

    public void setvSate(Integer vSate) {
        this.vSate = vSate;
    }

    public Date getvBranchTime() {
        return vBranchTime;
    }

    public void setvBranchTime(Date vBranchTime) {
        this.vBranchTime = vBranchTime;
    }

    public Date getvDirectorTime() {
        return vDirectorTime;
    }

    public void setvDirectorTime(Date vDirectorTime) {
        this.vDirectorTime = vDirectorTime;
    }

    public Date getvManagerTime() {
        return vManagerTime;
    }

    public void setvManagerTime(Date vManagerTime) {
        this.vManagerTime = vManagerTime;
    }

    public String getvReason() {
        return vReason;
    }

    public void setvReason(String vReason) {
        this.vReason = vReason == null ? null : vReason.trim();
    }

    public String getvBranch() {
        return vBranch;
    }

    public void setvBranch(String vBranch) {
        this.vBranch = vBranch == null ? null : vBranch.trim();
    }

    public String getvDirector() {
        return vDirector;
    }

    public void setvDirector(String vDirector) {
        this.vDirector = vDirector == null ? null : vDirector.trim();
    }

    public String getvManager() {
        return vManager;
    }

    public void setvManager(String vManager) {
        this.vManager = vManager == null ? null : vManager.trim();
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

	public String getvUrl() {
		return vUrl;
	}

	public void setvUrl(String vUrl) {
		this.vUrl = vUrl;
	}

	public String getvFileName() {
		return vFileName;
	}

	public void setvFileName(String vFileName) {
		this.vFileName = vFileName;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}
    
    
}