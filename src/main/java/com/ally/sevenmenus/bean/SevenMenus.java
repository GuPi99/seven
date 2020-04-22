package com.ally.sevenmenus.bean;

public class SevenMenus {
    
	private Integer id;

    private String mName;

    private String mTag;

    private Integer mMid;

    private String mUrl;

    private Integer mSort;

    private Integer mState;
    
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmTag() {
        return mTag;
    }

    public void setmTag(String mTag) {
        this.mTag = mTag == null ? null : mTag.trim();
    }

    public Integer getmMid() {
        return mMid;
    }

    public void setmMid(Integer mMid) {
        this.mMid = mMid;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl == null ? null : mUrl.trim();
    }

    public Integer getmSort() {
        return mSort;
    }

    public void setmSort(Integer mSort) {
        this.mSort = mSort;
    }

    public Integer getmState() {
        return mState;
    }

    public void setmState(Integer mState) {
        this.mState = mState;
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
	@Override
	public String toString() {
		return "SevenMenus [id=" + id + ", mName=" + mName + ", mTag=" + mTag + ", mMid=" + mMid + ", mUrl=" + mUrl
				+ ", mSort=" + mSort + ", mState=" + mState + ", state=" + state + "]";
	}

}