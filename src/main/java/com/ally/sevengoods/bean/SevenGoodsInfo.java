package com.ally.sevengoods.bean;

public class SevenGoodsInfo {

	private Integer ID;

    private String gCid;

    private String gName;

    private String gModel;

    private String gGid;

    private String gDescribe;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getgCid() {
		return gCid;
	}

	public void setgCid(String gCid) {
		this.gCid = gCid;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgModel() {
		return gModel;
	}

	public void setgModel(String gModel) {
		this.gModel = gModel;
	}

	public String getgGid() {
		return gGid;
	}

	public void setgGid(String gGid) {
		this.gGid = gGid;
	}

	public String getgDescribe() {
		return gDescribe;
	}

	public void setgDescribe(String gDescribe) {
		this.gDescribe = gDescribe;
	}

	@Override
	public String toString() {
		return "SevenGoodsInfo [ID=" + ID + ", gCid=" + gCid + ", gName=" + gName + ", gModel=" + gModel + ", gGid="
				+ gGid + ", gDescribe=" + gDescribe + "]";
	}
    
    
}
