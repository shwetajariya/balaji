package com.sur.balaji.model;

// Generated 7 Oct, 2013 7:45:53 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * ContactAuditId generated by hbm2java
 */
public class ContactAuditId implements java.io.Serializable {

	private String operation;
	private Long contactId;
	private String mobileNumber;
	private String emailAddress;
	private Long modifierId;
	private Date modifiedOn;

	public ContactAuditId() {
	}

	public ContactAuditId(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public ContactAuditId(String operation, Long contactId,
			String mobileNumber, String emailAddress, Long modifierId,
			Date modifiedOn) {
		this.operation = operation;
		this.contactId = contactId;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.modifierId = modifierId;
		this.modifiedOn = modifiedOn;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Long getContactId() {
		return this.contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Long getModifierId() {
		return this.modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ContactAuditId))
			return false;
		ContactAuditId castOther = (ContactAuditId) other;

		return ((this.getOperation() == castOther.getOperation()) || (this
				.getOperation() != null && castOther.getOperation() != null && this
				.getOperation().equals(castOther.getOperation())))
				&& ((this.getContactId() == castOther.getContactId()) || (this
						.getContactId() != null
						&& castOther.getContactId() != null && this
						.getContactId().equals(castOther.getContactId())))
				&& ((this.getMobileNumber() == castOther.getMobileNumber()) || (this
						.getMobileNumber() != null
						&& castOther.getMobileNumber() != null && this
						.getMobileNumber().equals(castOther.getMobileNumber())))
				&& ((this.getEmailAddress() == castOther.getEmailAddress()) || (this
						.getEmailAddress() != null
						&& castOther.getEmailAddress() != null && this
						.getEmailAddress().equals(castOther.getEmailAddress())))
				&& ((this.getModifierId() == castOther.getModifierId()) || (this
						.getModifierId() != null
						&& castOther.getModifierId() != null && this
						.getModifierId().equals(castOther.getModifierId())))
				&& ((this.getModifiedOn() == castOther.getModifiedOn()) || (this
						.getModifiedOn() != null
						&& castOther.getModifiedOn() != null && this
						.getModifiedOn().equals(castOther.getModifiedOn())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOperation() == null ? 0 : this.getOperation().hashCode());
		result = 37 * result
				+ (getContactId() == null ? 0 : this.getContactId().hashCode());
		result = 37
				* result
				+ (getMobileNumber() == null ? 0 : this.getMobileNumber()
						.hashCode());
		result = 37
				* result
				+ (getEmailAddress() == null ? 0 : this.getEmailAddress()
						.hashCode());
		result = 37
				* result
				+ (getModifierId() == null ? 0 : this.getModifierId()
						.hashCode());
		result = 37
				* result
				+ (getModifiedOn() == null ? 0 : this.getModifiedOn()
						.hashCode());
		return result;
	}

}
