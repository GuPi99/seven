package com.ally.sevenoffice.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenOffice {
    private Integer id;

    private Integer oSid;

    private Integer oBranch;

    private Integer oPost;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date oOffice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date oDeparture;
    
    private String departName;
    
    private String positionName;
    
    

    public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getoSid() {
        return oSid;
    }

    public void setoSid(Integer oSid) {
        this.oSid = oSid;
    }

    public Integer getoBranch() {
        return oBranch;
    }

    public void setoBranch(Integer oBranch) {
        this.oBranch = oBranch;
    }

    public Integer getoPost() {
        return oPost;
    }

    public void setoPost(Integer oPost) {
        this.oPost = oPost;
    }

    public Date getoOffice() {
        return oOffice;
    }

    public void setoOffice(Date oOffice) {
        this.oOffice = oOffice;
    }

    public Date getoDeparture() {
        return oDeparture;
    }

    public void setoDeparture(Date oDeparture) {
        this.oDeparture = oDeparture;
    }
}