package com.ally.sevendaily.bean;

public class SevenDaily {
    private Integer id;

    private Integer dSid;

    private String dDate;

    private Integer dType;

    private String dWork;
    
    private String staffName;

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

    public String getdDate() {
        return dDate;
    }

    public void setdDate(String dDate) {
        this.dDate = dDate == null ? null : dDate.trim();
    }

    public Integer getdType() {
        return dType;
    }

    public void setdType(Integer dType) {
        this.dType = dType;
    }

    public String getdWork() {
        return dWork;
    }

    public void setdWork(String dWork) {
        this.dWork = dWork == null ? null : dWork.trim();
    }

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
    
    
}