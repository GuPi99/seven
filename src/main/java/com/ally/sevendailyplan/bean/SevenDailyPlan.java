package com.ally.sevendailyplan.bean;

import com.ally.sevenevection.bean.SevenEvection;

public class SevenDailyPlan {
    private Integer id;

    private Integer dpSid;

    private String dpDate;

    private Integer dpType;

    private String dpWork;
    
    private String staffName;
    
    private Integer dpWhere;
    
    private Integer dpEid;
    
    private SevenEvection sevenEvection;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDpSid() {
        return dpSid;
    }

    public void setDpSid(Integer dpSid) {
        this.dpSid = dpSid;
    }

    public String getDpDate() {
        return dpDate;
    }

    public void setDpDate(String dpDate) {
        this.dpDate = dpDate == null ? null : dpDate.trim();
    }

    public Integer getDpType() {
        return dpType;
    }

    public void setDpType(Integer dpType) {
        this.dpType = dpType;
    }

    public String getDpWork() {
        return dpWork;
    }

    public void setDpWork(String dpWork) {
        this.dpWork = dpWork == null ? null : dpWork.trim();
    }

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getDpWhere() {
		return dpWhere;
	}

	public void setDpWhere(Integer dpWhere) {
		this.dpWhere = dpWhere;
	}

	public Integer getDpEid() {
		return dpEid;
	}

	public void setDpEid(Integer dpEid) {
		this.dpEid = dpEid;
	}

	public SevenEvection getSevenEvection() {
		return sevenEvection;
	}

	public void setSevenEvection(SevenEvection sevenEvection) {
		this.sevenEvection = sevenEvection;
	}
    
    
}