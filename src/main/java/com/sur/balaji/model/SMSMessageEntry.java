package com.sur.balaji.model;

public class SMSMessageEntry {

	private String smsText;
	private String mobileNumber;
	private Contact contact;
	private int status;

	public String getSmsText() {
		return smsText;
	}
	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SMSMessageEntry [smsText=" + smsText + 
				", contact=" + contact + 
				", mobileNumber=" + mobileNumber + 
				", status=" + status + "]";
	}
}
