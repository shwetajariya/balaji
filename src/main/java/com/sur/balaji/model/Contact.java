package com.sur.balaji.model;
// Generated 7 Oct, 2013 7:45:53 PM by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Contact generated by hbm2java
 */
public class Contact extends ModelBase implements java.io.Serializable {


     private Long contactId;
     private Department department;
     private Company company;
     private Designation designation;
     private User user;
     private Section section;
     private String employeeId;
     private String firstName;
     private String lastName;
     private Integer priority;
     private String officePhoneNumber;
     private String mobileNumber;
     private String residencePhoneNumber;
     private String emailAddress;
     private Date modifiedOn;
     private Set<MessageStatus> messageStatuses = new HashSet<MessageStatus>(0);
     private Set<ContactGroupMapping> contactGroupMappings = new HashSet<ContactGroupMapping>(0);

    public Contact() {
    }

	
    public Contact(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    public Contact(Department department, Company company, Designation designation, User user, Section section, String employeeId, String firstName, String lastName, Integer priority, String officePhoneNumber, String mobileNumber, String residencePhoneNumber, String emailAddress, Date modifiedOn, Set<MessageStatus> messageStatuses, Set<ContactGroupMapping> contactGroupMappings) {
       this.department = department;
       this.company = company;
       this.designation = designation;
       this.user = user;
       this.section = section;
       this.employeeId = employeeId;
       this.firstName = firstName;
       this.lastName = lastName;
       this.priority = priority;
       this.officePhoneNumber = officePhoneNumber;
       this.mobileNumber = mobileNumber;
       this.residencePhoneNumber = residencePhoneNumber;
       this.emailAddress = emailAddress;
       this.modifiedOn = modifiedOn;
       this.messageStatuses = messageStatuses;
       this.contactGroupMappings = contactGroupMappings;
    }
   
    public Long getContactId() {
        return this.contactId;
    }
    
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
    public Designation getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Section getSection() {
        return this.section;
    }
    
    public void setSection(Section section) {
        this.section = section;
    }
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getPriority() {
        return this.priority;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public String getOfficePhoneNumber() {
        return this.officePhoneNumber;
    }
    
    public void setOfficePhoneNumber(String officePhoneNumber) {
        this.officePhoneNumber = officePhoneNumber;
    }
    public String getMobileNumber() {
        return this.mobileNumber;
    }
    
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getResidencePhoneNumber() {
        return this.residencePhoneNumber;
    }
    
    public void setResidencePhoneNumber(String residencePhoneNumber) {
        this.residencePhoneNumber = residencePhoneNumber;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public Date getModifiedOn() {
        return this.modifiedOn;
    }
    
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    public Set<MessageStatus> getMessageStatuses() {
        return this.messageStatuses;
    }
    
    public void setMessageStatuses(Set<MessageStatus> messageStatuses) {
        this.messageStatuses = messageStatuses;
    }
    public Set<ContactGroupMapping> getContactGroupMappings() {
        return this.contactGroupMappings;
    }
    
    public void setContactGroupMappings(Set<ContactGroupMapping> contactGroupMappings) {
        this.contactGroupMappings = contactGroupMappings;
    }

	public String getContactName() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.firstName==null?"":this.firstName);
		sb.append(" ");
		sb.append(this.lastName==null?"":this.lastName);
		sb.append(" - ");
		sb.append(this.department==null?"":this.department.getDepartmentName());
		sb.append(" [");
		sb.append(this.employeeId);
		sb.append("]");
		return sb.toString();
	}
}


