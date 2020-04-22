package com.ally.sevenaccount.bean;

public class SevenAccount {
    private Integer id;

    private String aAccount;

    private String aPassword;

    private Integer aRid;

    private String aNickname;

    private Integer aPid;

    private Integer aState;

    private Integer aSid;
    
    private String state;
    
    private String roleName;
    
    private String staffName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getaAccount() {
        return aAccount;
    }

    public void setaAccount(String aAccount) {
        this.aAccount = aAccount == null ? null : aAccount.trim();
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }

    public Integer getaRid() {
        return aRid;
    }

    public void setaRid(Integer aRid) {
        this.aRid = aRid;
    }

    public String getaNickname() {
        return aNickname;
    }

    public void setaNickname(String aNickname) {
        this.aNickname = aNickname == null ? null : aNickname.trim();
    }

    public Integer getaPid() {
        return aPid;
    }

    public void setaPid(Integer aPid) {
        this.aPid = aPid;
    }

    public Integer getaState() {
        return aState;
    }

    public void setaState(Integer aState) {
        this.aState = aState;
    }

    public Integer getaSid() {
        return aSid;
    }

    public void setaSid(Integer aSid) {
        this.aSid = aSid;
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
    
    
}