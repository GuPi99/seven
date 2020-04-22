package com.ally.sevenproject.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenProject {
    private Integer id;

    private Integer pSid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pDatetime;

    private Integer pFid;

    private String pConditions;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
   	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date pDate;

    private String pNote;
    
    private String StaffName;
    
    private String FirmName;
    
    private String nowState;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpSid() {
        return pSid;
    }

    public void setpSid(Integer pSid) {
        this.pSid = pSid;
    }

    public Date getpDatetime() {
        return pDatetime;
    }

    public void setpDatetime(Date pDatetime) {
        this.pDatetime = pDatetime;
    }

    public Integer getpFid() {
        return pFid;
    }

    public void setpFid(Integer pFid) {
        this.pFid = pFid;
    }

    public String getpConditions() {
        return pConditions;
    }

    public void setpConditions(String pConditions) {
        this.pConditions = pConditions == null ? null : pConditions.trim();
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public String getpNote() {
        return pNote;
    }

    public void setpNote(String pNote) {
        this.pNote = pNote == null ? null : pNote.trim();
    }

	public String getStaffName() {
		return StaffName;
	}

	public void setStaffName(String staffName) {
		StaffName = staffName;
	}

	public String getFirmName() {
		return FirmName;
	}

	public void setFirmName(String firmName) {
		FirmName = firmName;
	}

	public String getNowState() {
		return nowState;
	}

	public void setNowState(String nowState) {
		this.nowState = nowState;
	}
    
    
}