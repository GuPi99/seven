package com.ally.sevenprofile.bean;

public class SevenProfile {
    private Integer id;

    private Integer pFid;

    private String pSite;
    
    private String firmName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpFid() {
        return pFid;
    }

    public void setpFid(Integer pFid) {
        this.pFid = pFid;
    }

    public String getpSite() {
        return pSite;
    }

    public void setpSite(String pSite) {
        this.pSite = pSite == null ? null : pSite.trim();
    }

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
    
    
}