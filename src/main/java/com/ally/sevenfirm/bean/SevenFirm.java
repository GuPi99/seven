package com.ally.sevenfirm.bean;

public class SevenFirm {
    private Integer id;

    private Integer fFid;

    private String fName;

    private String fPhone;

    private String fEmail;

    private String fFax;

    private String fEin;

    private String fSite;

    private Integer fSid;
    
    private String CompanyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getfFid() {
        return fFid;
    }

    public void setfFid(Integer fFid) {
        this.fFid = fFid;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone == null ? null : fPhone.trim();
    }

    public String getfEmail() {
        return fEmail;
    }

    public void setfEmail(String fEmail) {
        this.fEmail = fEmail == null ? null : fEmail.trim();
    }

    public String getfFax() {
        return fFax;
    }

    public void setfFax(String fFax) {
        this.fFax = fFax == null ? null : fFax.trim();
    }

    public String getfEin() {
        return fEin;
    }

    public void setfEin(String fEin) {
        this.fEin = fEin == null ? null : fEin.trim();
    }

    public String getfSite() {
        return fSite;
    }

    public void setfSite(String fSite) {
        this.fSite = fSite == null ? null : fSite.trim();
    }

    public Integer getfSid() {
        return fSid;
    }

    public void setfSid(Integer fSid) {
        this.fSid = fSid;
    }

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
    
    
}