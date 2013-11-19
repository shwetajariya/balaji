package com.sur.balaji.model;
// Generated 7 Oct, 2013 7:45:53 PM by Hibernate Tools 4.0.0


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Contact generated by hbm2java
 */
public class Contact extends ModelBase implements Serializable, Comparable<Contact> {


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
     
     // Extended properties for Drop-Down GUI integration
     private Long companyId;
     private Long designationId;
     private Long sectionId;
     private Long departmentId;

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
       
       this.companyId = this.company==null ? null : this.company.getCompanyId();
   	   this.designationId = this.designation==null ? null : this.designation.getDesignationId();
   	   this.sectionId = this.section==null ? null : this.section.getSectionId();
   	   this.departmentId = this.department==null ? null : this.department.getDepartmentId();
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
    
    public Long getContactId() {
        return this.contactId;
    }
    
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public void setCompany(Company company) {
        this.company = company;
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

	public Long getCompanyId() {
		if(companyId != null){
			return companyId;
		} else if (company != null) {
			return company.getCompanyId();
		} else {
			return null;
		}
	}
	public Company getCompany() {
		Company company1 = this.company;
		if(company1 == null && this.companyId != null) {
			company1 = new Company();
			company1.setCompanyId(this.companyId);
		}
		return company1;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	public Long getDesignationId() {
		if(designationId != null){
			return designationId;
		} else if (designation != null) {
			return designation.getDesignationId();
		} else {
			return null;
		}
	}
	public Designation getDesignation() {
		Designation designation1 = this.designation;
		if(designation1 == null && this.designationId != null) {
			designation1 = new Designation();
			designation1.setDesignationId(this.designationId);
		}
		return designation1;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
	
	public Long getSectionId() {
		if(sectionId != null){
			return sectionId;
		} else if (section != null) {
			return section.getSectionId();
		} else {
			return null;
		}
	}
	public Section getSection() {
		Section section1 = this.section;
		if(section1 == null && this.sectionId != null) {
			section1 = new Section();
			section1.setSectionId(this.sectionId);
		}
		return section1;
	}
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	
	public Long getDepartmentId() {
		if(companyId != null){
			return companyId;
		} else if (company != null) {
			return company.getCompanyId();
		} else {
			return null;
		}
	}
	public Department getDepartment() {
		Department department1 = this.department;
		if(department1 == null && this.departmentId != null) {
			department1 = new Department();
			department1.setDepartmentId(this.departmentId);
		}
		return department1;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", department=" + department
				+ ", company=" + company + ", designation=" + designation
				+ ", user=" + user + ", section=" + section + ", employeeId="
				+ employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", priority=" + priority + ", officePhoneNumber="
				+ officePhoneNumber + ", mobileNumber=" + mobileNumber
				+ ", residencePhoneNumber=" + residencePhoneNumber
				+ ", emailAddress=" + emailAddress + ", modifiedOn="
				+ modifiedOn + ", messageStatuses=" + messageStatuses
				+ ", contactGroupMappings=" + contactGroupMappings
				+ ", companyId=" + companyId + ", designationId="
				+ designationId + ", sectionId=" + sectionId
				+ ", departmentId=" + departmentId + "]";
	}

	@Override
	public int compareTo(Contact o) {
		if(this.contactId == null){
			return 1; // not equal
		}
		return (int) (this.contactId - o.getContactId());
	}
	
	@Override
	public int hashCode() {
		if(this.contactId == null){
			return super.hashCode();
		}
		return this.contactId.hashCode();
	}
}
