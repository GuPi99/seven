package com.ally.sevennotice.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ally.sevennoticefile.bean.SevenNoticeFile;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenNotice {
    private Integer id;

    private String title;

    private String dispatchNumber;

    private Integer draftId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date draftDate;

    private Integer nationFileId;

    private String text;
    
    private SevenNoticeFile sevenNoticeFile;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDispatchNumber() {
        return dispatchNumber;
    }

    public void setDispatchNumber(String dispatchNumber) {
        this.dispatchNumber = dispatchNumber == null ? null : dispatchNumber.trim();
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

    public Integer getNationFileId() {
        return nationFileId;
    }

    public void setNationFileId(Integer nationFileId) {
        this.nationFileId = nationFileId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

	public SevenNoticeFile getSevenNoticeFile() {
		return sevenNoticeFile;
	}

	public void setSevenNoticeFile(SevenNoticeFile sevenNoticeFile) {
		this.sevenNoticeFile = sevenNoticeFile;
	}
    
    
}