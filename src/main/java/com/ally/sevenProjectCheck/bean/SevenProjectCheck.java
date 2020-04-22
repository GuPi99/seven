package com.ally.sevenProjectCheck.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenProjectCheck {
    private Integer id;

    private Integer pcPid;

    private Integer pcState;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pcTime;

    private Integer pcSid;

    private String pcEvaluation;
    
    private Integer pcOther;
    
    public Integer getPcOther() {
		return pcOther;
	}

	public void setPcOther(Integer pcOther) {
		this.pcOther = pcOther;
	}

	private String staffName;
    
    private String nowState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPcPid() {
        return pcPid;
    }

    public void setPcPid(Integer pcPid) {
        this.pcPid = pcPid;
    }

    public Integer getPcState() {
        return pcState;
    }

    public void setPcState(Integer pcState) {
        this.pcState = pcState;
    }

    public Date getPcTime() {
        return pcTime;
    }

    public void setPcTime(Date pcTime) {
        this.pcTime = pcTime;
    }

    public Integer getPcSid() {
        return pcSid;
    }

    public void setPcSid(Integer pcSid) {
        this.pcSid = pcSid;
    }

    public String getPcEvaluation() {
        return pcEvaluation;
    }

    public void setPcEvaluation(String pcEvaluation) {
        this.pcEvaluation = pcEvaluation == null ? null : pcEvaluation.trim();
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