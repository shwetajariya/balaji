package com.sur.balaji.model;

import java.util.List;

public class SMSMessage {

	private Long messageId;
    private User user;
    private String messageText;
    private String mobileNumbers;
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
	public String getMobileNumbers() {
		return mobileNumbers;
	}
	public void setMobileNumbers(String mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
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
				+ mobileNumbers + ", timeoutMilliSec=" + timeoutMilliSec
				+ ", selectedContacts=" + selectedContacts
				+ ", selectedGroups=" + selectedGroups + ", status=" + status
				+ "]";
	}
}
