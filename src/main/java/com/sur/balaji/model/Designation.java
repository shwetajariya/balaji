package com.sur.balaji.model;

// Generated 7 Oct, 2013 7:45:53 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Designation generated by hbm2java
 */
public class Designation extends ModelBase implements java.io.Serializable {

	private Long designationId;
	private String designation;
	private Integer priority;
	@JsonIgnore
	private Set<Contact> contacts = new HashSet<Contact>(0);

	public Designation() {
	}

	public Designation(String designation, Integer priority,
			Set<Contact> contacts) {
		this.designation = designation;
		this.priority = priority;
		this.contacts = contacts;
	}

	public Long getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

}
