package com.ally.seventerrace.bean;

public class SevenTerrace {
    private Integer id;

    private Integer tFid;

    private String tName;

    private String tUrl;

    private String tEmail;

    private String tPaw;

    private Integer tState;
    
    private String firmName;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer gettFid() {
        return tFid;
    }

    public void settFid(Integer tFid) {
        this.tFid = tFid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettUrl() {
        return tUrl;
    }

    public void settUrl(String tUrl) {
        this.tUrl = tUrl == null ? null : tUrl.trim();
    }

    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail == null ? null : tEmail.trim();
    }

    public String gettPaw() {
        return tPaw;
    }

    public void settPaw(String tPaw) {
        this.tPaw = tPaw == null ? null : tPaw.trim();
    }

    public Integer gettState() {
        return tState;
    }

    public void settState(Integer tState) {
        this.tState = tState;
    }

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
    
    
}