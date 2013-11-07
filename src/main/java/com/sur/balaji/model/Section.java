package com.sur.balaji.model;
// Generated 7 Oct, 2013 7:45:53 PM by Hibernate Tools 4.0.0


import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Section generated by hbm2java
 */
public class Section extends ModelBase implements java.io.Serializable {


     private Long sectionId;
     private String sectionName;
     @JsonIgnore
     private Set<Contact> contacts = new HashSet<Contact>(0);

    public Section() {
    }

    public Section(String sectionName, Set<Contact> contacts) {
       this.sectionName = sectionName;
       this.contacts = contacts;
    }
   
    public Long getSectionId() {
        return this.sectionId;
    }
    
    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
    public String getSectionName() {
        return this.sectionName;
    }
    
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
    public Set<Contact> getContacts() {
        return this.contacts;
    }
    
    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }




}


