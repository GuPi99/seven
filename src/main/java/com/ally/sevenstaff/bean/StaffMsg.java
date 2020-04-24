package com.ally.sevenstaff.bean;

import com.ally.sevenmessage.bean.SevenMessage;

public class StaffMsg {

	private SevenStaff sevenStaff;
	
	private SevenMessage sevenMessage;
	
	private String iUrl;

	public SevenStaff getSevenStaff() {
		return sevenStaff;
	}

	public void setSevenStaff(SevenStaff sevenStaff) {
		this.sevenStaff = sevenStaff;
	}

	public SevenMessage getSevenMessage() {
		return sevenMessage;
	}

	public void setSevenMessage(SevenMessage sevenMessage) {
		this.sevenMessage = sevenMessage;
	}

	public String getiUrl() {
		return iUrl;
	}

	public void setiUrl(String iUrl) {
		this.iUrl = iUrl;
	}
	
	
	
}
