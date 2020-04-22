package com.ally.sevenprojectreport.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenProjectReport {
    private Integer id;

    private Integer prPid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date prTime;

    private String prReport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrPid() {
        return prPid;
    }

    public void setPrPid(Integer prPid) {
        this.prPid = prPid;
    }

    public Date getPrTime() {
        return prTime;
    }

    public void setPrTime(Date prTime) {
        this.prTime = prTime;
    }

    public String getPrReport() {
        return prReport;
    }

    public void setPrReport(String prReport) {
        this.prReport = prReport == null ? null : prReport.trim();
    }
}