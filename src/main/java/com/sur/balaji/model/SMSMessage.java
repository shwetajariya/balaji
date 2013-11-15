package com.sur.balaji.model;

import java.util.List;

public class SMSMessage {

	private Long messageId;
    private User user;
    private String messageText;
    private Integer mobileNumber;
	private String timeoutMilliSec;
    private List<String> selectedContacts;
    private List<String> selectedGroups;
    private Integer status;
    
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getTimeoutMilliSec() {
		return timeoutMilliSec;
	}
	public void setTimeoutMilliSec(String timeoutMilliSec) {
		this.timeoutMilliSec = timeoutMilliSec;
	}
	public List<String> getSelectedContacts() {
		return selectedContacts;
	}
	public void setSelectedContacts(List<String> selectedContacts) {
		this.selectedContacts = selectedContacts;
	}
	public List<String> getSelectedGroups() {
		return selectedGroups;
	}
	public void setSelectedGroups(List<String> selectedGroups) {
		this.selectedGroups = selectedGroups;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SMSMessage [messageId=" + messageId + ", user=" + user
				+ ", messageText=" + messageText + ", mobileNumber="
				+ mobileNumber + ", timeoutMilliSec=" + timeoutMilliSec
				+ ", selectedContacts=" + selectedContacts
				+ ", selectedGroups=" + selectedGroups + ", status=" + status
				+ "]";
	}
}
