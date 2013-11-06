package com.sur.balaji.model;
// Generated 7 Oct, 2013 7:45:53 PM by Hibernate Tools 4.0.0


import java.util.HashSet;
import java.util.Set;

/**
 * Groups generated by hbm2java
 */
public class Groups extends ModelBase  implements java.io.Serializable {


     private Long groupId;
     private String groupName;
     private Set<ContactGroupMapping> contactGroupMappings = new HashSet<ContactGroupMapping>(0);

    public Groups() {
    }

    public Groups(String groupName, Set<ContactGroupMapping> contactGroupMappings) {
       this.groupName = groupName;
       this.contactGroupMappings = contactGroupMappings;
    }
   
    public Long getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public Set<ContactGroupMapping> getContactGroupMappings() {
        return this.contactGroupMappings;
    }
    
    public void setContactGroupMappings(Set<ContactGroupMapping> contactGroupMappings) {
        this.contactGroupMappings = contactGroupMappings;
    }




}


