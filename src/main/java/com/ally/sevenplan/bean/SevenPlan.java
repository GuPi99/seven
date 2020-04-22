package com.ally.sevenplan.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenPlan {
    private Integer id;

    private Integer pEid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date pDate;

    private Integer pIs;

    private String pVehicle;

    private Integer pFid;

    private String pGoal;
    
    private String firmName;
    
    private String isState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpEid() {
        return pEid;
    }

    public void setpEid(Integer pEid) {
        this.pEid = pEid;
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public Integer getpIs() {
        return pIs;
    }

    public void setpIs(Integer pIs) {
        this.pIs = pIs;
    }

    public String getpVehicle() {
        return pVehicle;
    }

    public void setpVehicle(String pVehicle) {
        this.pVehicle = pVehicle == null ? null : pVehicle.trim();
    }

    public Integer getpFid() {
        return pFid;
    }

    public void setpFid(Integer pFid) {
        this.pFid = pFid;
    }

    public String getpGoal() {
        return pGoal;
    }

    public void setpGoal(String pGoal) {
        this.pGoal = pGoal == null ? null : pGoal.trim();
    }

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getIsState() {
		return isState;
	}

	public void setIsState(String isState) {
		this.isState = isState;
	}
    
    
}