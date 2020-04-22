package com.ally.sevengoods.bean;


public class SevenGoods {
    private Integer id;

    private Integer gCid;

    private String gName;

    private String gModel;

    private Integer gGid;

    private String gDescribe;
    
    private String cName;
    
    private String OnName;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getgCid() {
        return gCid;
    }

    public void setgCid(Integer gCid) {
        this.gCid = gCid;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public String getgModel() {
        return gModel;
    }

    public void setgModel(String gModel) {
        this.gModel = gModel == null ? null : gModel.trim();
    }

    public Integer getgGid() {
        return gGid;
    }

    public void setgGid(Integer gGid) {
        this.gGid = gGid;
    }

    public String getgDescribe() {
        return gDescribe;
    }

    public void setgDescribe(String gDescribe) {
        this.gDescribe = gDescribe == null ? null : gDescribe.trim();
    }

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getOnName() {
		return OnName;
	}

	public void setOnName(String onName) {
		OnName = onName;
	}


    
	
}