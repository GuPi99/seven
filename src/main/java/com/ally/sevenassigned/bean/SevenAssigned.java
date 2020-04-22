package com.ally.sevenassigned.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenAssigned {
    private Integer id;

    private Integer aSid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date aDatetime;

    private Integer aState;
    
    private Integer aRead;

    private String aWork;

    private String aRemark;
    
    private String staffName;

    private String state;
    
    private String readStatus;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getaSid() {
        return aSid;
    }

    public void setaSid(Integer aSid) {
        this.aSid = aSid;
    }

    public Date getaDatetime() {
        return aDatetime;
    }

    public void setaDatetime(Date aDatetime) {
        this.aDatetime = aDatetime;
    }

    public Integer getaState() {
        return aState;
    }

    public void setaState(Integer aState) {
        this.aState = aState;
    }

    public String getaWork() {
        return aWork;
    }

    public void setaWork(String aWork) {
        this.aWork = aWork == null ? null : aWork.trim();
    }

    public String getaRemark() {
        return aRemark;
    }

    public void setaRemark(String aRemark) {
        this.aRemark = aRemark == null ? null : aRemark.trim();
    }

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getaRead() {
		return aRead;
	}

	public void setaRead(Integer aRead) {
		this.aRead = aRead;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

    
    
}