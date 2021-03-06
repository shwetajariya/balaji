package com.sur.balaji.model;

// Generated 7 Oct, 2013 7:45:53 PM by Hibernate Tools 4.0.0

/**
 * MessageStatusId generated by hbm2java
 */
public class MessageStatusId implements java.io.Serializable {

	private Long messageLogId;
	private Long contactId;
	private String contactNumber;
	private Integer statusCode;

	public MessageStatusId() {
	}

	public MessageStatusId(Long messageLogId, Long contactId,
			String contactNumber, Integer statusCode) {
		this.messageLogId = messageLogId;
		this.contactId = contactId;
		this.contactNumber = contactNumber;
		this.statusCode = statusCode;
	}

	public Long getMessageLogId() {
		return this.messageLogId;
	}

	public void setMessageLogId(Long messageLogId) {
		this.messageLogId = messageLogId;
	}

	public Long getContactId() {
		return this.contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MessageStatusId))
			return false;
		MessageStatusId castOther = (MessageStatusId) other;

		return ((this.getMessageLogId() == castOther.getMessageLogId()) || (this
				.getMessageLogId() != null
				&& castOther.getMessageLogId() != null && this
				.getMessageLogId().equals(castOther.getMessageLogId())))
				&& ((this.getContactId() == castOther.getContactId()) || (this
						.getContactId() != null
						&& castOther.getContactId() != null && this
						.getContactId().equals(castOther.getContactId())))
				&& ((this.getContactNumber() == castOther.getContactNumber()) || (this
						.getContactNumber() != null
						&& castOther.getContactNumber() != null && this
						.getContactNumber()
						.equals(castOther.getContactNumber())))
				&& ((this.getStatusCode() == castOther.getStatusCode()) || (this
						.getStatusCode() != null
						&& castOther.getStatusCode() != null && this
						.getStatusCode().equals(castOther.getStatusCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMessageLogId() == null ? 0 : this.getMessageLogId()
						.hashCode());
		result = 37 * result
				+ (getContactId() == null ? 0 : this.getContactId().hashCode());
		result = 37
				* result
				+ (getContactNumber() == null ? 0 : this.getContactNumber()
						.hashCode());
		result = 37
				* result
				+ (getStatusCode() == null ? 0 : this.getStatusCode()
						.hashCode());
		return result;
	}

}
