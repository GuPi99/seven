package com.ally.sevenprojectschedule.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenProjectSchedule {
    private Integer id;

    private Integer psPid;

    private String psUrl;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date psTime;

    private String psContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPsPid() {
        return psPid;
    }

    public void setPsPid(Integer psPid) {
        this.psPid = psPid;
    }

    public String getPsUrl() {
        return psUrl;
    }

    public void setPsUrl(String psUrl) {
        this.psUrl = psUrl == null ? null : psUrl.trim();
    }

    public Date getPsTime() {
        return psTime;
    }

    public void setPsTime(Date psTime) {
        this.psTime = psTime;
    }

    public String getPsContent() {
        return psContent;
    }

    public void setPsContent(String psContent) {
        this.psContent = psContent == null ? null : psContent.trim();
    }
}