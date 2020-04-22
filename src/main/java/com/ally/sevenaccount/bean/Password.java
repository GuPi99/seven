package com.ally.sevenaccount.bean;

public class Password {

	private String paw;
	
	private String paws;
	
	private String pawss;

	public String getPaw() {
		return paw;
	}

	public void setPaw(String paw) {
		this.paw = paw;
	}

	public String getPaws() {
		return paws;
	}

	public void setPaws(String paws) {
		this.paws = paws;
	}

	public String getPawss() {
		return pawss;
	}

	public void setPawss(String pawss) {
		this.pawss = pawss;
	}

	@Override
	public String toString() {
		return "Password [paw=" + paw + ", paws=" + paws + ", pawss=" + pawss + ", getPaw()=" + getPaw()
				+ ", getPaws()=" + getPaws() + ", getPawss()=" + getPawss() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
