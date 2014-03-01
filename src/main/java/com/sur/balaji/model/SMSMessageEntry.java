package com.sur.balaji.model;

import org.springframework.util.StringUtils;

public class SMSMessageEntry {

	private String smsText;
	private String mobileNumber;
	private Contact contact;
	private int status;
	private String gatewayID;
	
	

	public String getGatewayID() {
		return gatewayID;
	}

	public void setGatewayID(String gatewayID) {
		this.gatewayID = gatewayID;
	}

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
	
	public String getMobileNumberImpl(){
		String number = this.mobileNumber;
		if(contact != null){
			if(! StringUtils.isEmpty(contact.getMobileNumber())){
				number = contact.getMobileNumber();
			}
		}
		return number;
	}

	@Override
	public String toString() {
		return "SMSMessageEntry [smsText=" + smsText + ", contact=" + contact
				+ ", mobileNumber=" + mobileNumber + ", status=" + status + "]";
	}
}
