package com.ally.sevenbankaccount.bean;

public class SevenBankAccount {
    private Integer id;

    private Integer baFid;

    private Integer baBid;

    private String baAccount;
    
    private String bankName;
    
    private String firmName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBaFid() {
        return baFid;
    }

    public void setBaFid(Integer baFid) {
        this.baFid = baFid;
    }

    public Integer getBaBid() {
        return baBid;
    }

    public void setBaBid(Integer baBid) {
        this.baBid = baBid;
    }

    public String getBaAccount() {
        return baAccount;
    }

    public void setBaAccount(String baAccount) {
        this.baAccount = baAccount == null ? null : baAccount.trim();
    }

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
    
    
}