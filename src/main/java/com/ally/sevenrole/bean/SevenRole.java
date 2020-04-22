package com.ally.sevenrole.bean;


public class SevenRole {
    private Integer id;

    private String rName;

    private String rPermissions;

    private String rDescribe;
    

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrPermissions() {
        return rPermissions;
    }

    public void setrPermissions(String rPermissions) {
        this.rPermissions = rPermissions == null ? null : rPermissions.trim();
    }

    public String getrDescribe() {
        return rDescribe;
    }

    public void setrDescribe(String rDescribe) {
        this.rDescribe = rDescribe == null ? null : rDescribe.trim();
    }
    
    
    
}