package com.ally.sevenprojectfundplan.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenProjectFundPlan {
    private Integer id;

    private Integer pfpPid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date pfpPlanDate;

    private String pfpPlanSum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date pfpActualDate;

    private String pfpActualSum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPfpPid() {
        return pfpPid;
    }

    public void setPfpPid(Integer pfpPid) {
        this.pfpPid = pfpPid;
    }

    public Date getPfpPlanDate() {
        return pfpPlanDate;
    }

    public void setPfpPlanDate(Date pfpPlanDate) {
        this.pfpPlanDate = pfpPlanDate;
    }

    public String getPfpPlanSum() {
        return pfpPlanSum;
    }

    public void setPfpPlanSum(String pfpPlanSum) {
        this.pfpPlanSum = pfpPlanSum == null ? null : pfpPlanSum.trim();
    }

    public Date getPfpActualDate() {
        return pfpActualDate;
    }

    public void setPfpActualDate(Date pfpActualDate) {
        this.pfpActualDate = pfpActualDate;
    }

    public String getPfpActualSum() {
        return pfpActualSum;
    }

    public void setPfpActualSum(String pfpActualSum) {
        this.pfpActualSum = pfpActualSum == null ? null : pfpActualSum.trim();
    }
}