package com.ally.sevenprint.bean;

public class SevenPrint {
    private Integer id;

    private String pName;

    private String pUrl;

    private Integer pAid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl == null ? null : pUrl.trim();
    }

    public Integer getpAid() {
        return pAid;
    }

    public void setpAid(Integer pAid) {
        this.pAid = pAid;
    }
}