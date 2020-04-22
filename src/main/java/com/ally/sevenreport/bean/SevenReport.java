package com.ally.sevenreport.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenReport {
    private Integer id;

    private Integer rSid;

    private String rCrew;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date rDate;

    private String rTitle;

    private String rFirm;

    private String rUser;

    private String rGoal;

    private String rVerdict;

    private String rRecord;

    private String rActivity;

    private String rAssist;

    private String rIndicate;

    private String rContact;

    private String rReply;
    
    private String staffName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getrSid() {
        return rSid;
    }

    public void setrSid(Integer rSid) {
        this.rSid = rSid;
    }

    public String getrCrew() {
        return rCrew;
    }

    public void setrCrew(String rCrew) {
        this.rCrew = rCrew == null ? null : rCrew.trim();
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public String getrTitle() {
        return rTitle;
    }

    public void setrTitle(String rTitle) {
        this.rTitle = rTitle == null ? null : rTitle.trim();
    }

    public String getrFirm() {
        return rFirm;
    }

    public void setrFirm(String rFirm) {
        this.rFirm = rFirm == null ? null : rFirm.trim();
    }

    public String getrUser() {
        return rUser;
    }

    public void setrUser(String rUser) {
        this.rUser = rUser == null ? null : rUser.trim();
    }

    public String getrGoal() {
        return rGoal;
    }

    public void setrGoal(String rGoal) {
        this.rGoal = rGoal == null ? null : rGoal.trim();
    }

    public String getrVerdict() {
        return rVerdict;
    }

    public void setrVerdict(String rVerdict) {
        this.rVerdict = rVerdict == null ? null : rVerdict.trim();
    }

    public String getrRecord() {
        return rRecord;
    }

    public void setrRecord(String rRecord) {
        this.rRecord = rRecord == null ? null : rRecord.trim();
    }

    public String getrActivity() {
        return rActivity;
    }

    public void setrActivity(String rActivity) {
        this.rActivity = rActivity == null ? null : rActivity.trim();
    }

    public String getrAssist() {
        return rAssist;
    }

    public void setrAssist(String rAssist) {
        this.rAssist = rAssist == null ? null : rAssist.trim();
    }

    public String getrIndicate() {
        return rIndicate;
    }

    public void setrIndicate(String rIndicate) {
        this.rIndicate = rIndicate == null ? null : rIndicate.trim();
    }

    public String getrContact() {
        return rContact;
    }

    public void setrContact(String rContact) {
        this.rContact = rContact == null ? null : rContact.trim();
    }

    public String getrReply() {
        return rReply;
    }

    public void setrReply(String rReply) {
        this.rReply = rReply == null ? null : rReply.trim();
    }

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "SevenReport [id=" + id + ", rSid=" + rSid + ", rCrew=" + rCrew + ", rDate=" + rDate + ", rTitle="
				+ rTitle + ", rFirm=" + rFirm + ", rUser=" + rUser + ", rGoal=" + rGoal + ", rVerdict=" + rVerdict
				+ ", rRecord=" + rRecord + ", rActivity=" + rActivity + ", rAssist=" + rAssist + ", rIndicate="
				+ rIndicate + ", rContact=" + rContact + ", rReply=" + rReply + ", staffName=" + staffName + "]";
	}
    
    
}