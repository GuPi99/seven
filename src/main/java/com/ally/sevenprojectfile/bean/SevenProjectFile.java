package com.ally.sevenprojectfile.bean;

public class SevenProjectFile {
    private Integer id;

    private Integer pfPid;

    private String pfName;

    private String pfUrl;

    private String pfType;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPfPid() {
        return pfPid;
    }

    public void setPfPid(Integer pfPid) {
        this.pfPid = pfPid;
    }

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName == null ? null : pfName.trim();
    }

    public String getPfUrl() {
        return pfUrl;
    }

    public void setPfUrl(String pfUrl) {
        this.pfUrl = pfUrl == null ? null : pfUrl.trim();
    }

    public String getPfType() {
        return pfType;
    }

    public void setPfType(String pfType) {
        this.pfType = pfType == null ? null : pfType.trim();
    }

    
    
}