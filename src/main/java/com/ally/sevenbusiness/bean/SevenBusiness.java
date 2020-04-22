package com.ally.sevenbusiness.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ally.sevenbusinessfile.bean.SevenBusinessFile;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenBusiness {
    private Integer id;

    private Integer staffId;

    private String title;

    private Integer draftId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date draftDate;

    private Integer status;

    private Integer businessId; //文件id

    private String text;
    
    private String dispatchNumber;
    
    private String draftName;
    
    private SevenBusinessFile sevenBusinessFile;
    
    private String readStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getDraftId() {
        return draftId;
    }

    public void setDraftId(Integer draftId) {
        this.draftId = draftId;
    }

    public Date getDraftDate() {
        return draftDate;
    }

    public void setDraftDate(Date draftDate) {
        this.draftDate = draftDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

	public String getDispatchNumber() {
		return dispatchNumber;
	}

	public void setDispatchNumber(String dispatchNumber) {
		this.dispatchNumber = dispatchNumber;
	}

	public SevenBusinessFile getSevenBusinessFile() {
		return sevenBusinessFile;
	}

	public void setSevenBusinessFile(SevenBusinessFile sevenBusinessFile) {
		this.sevenBusinessFile = sevenBusinessFile;
	}

	public String getDraftName() {
		return draftName;
	}

	public void setDraftName(String draftName) {
		this.draftName = draftName;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
	
	
}