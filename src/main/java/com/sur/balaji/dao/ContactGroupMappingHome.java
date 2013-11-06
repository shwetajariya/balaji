package com.sur.balaji.dao;
// Generated 7 Oct, 2013 7:45:54 PM by Hibernate Tools 4.0.0


import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sur.balaji.model.ContactGroupMapping;
import com.sur.balaji.model.ContactGroupMappingId;

/**
 * Home object for domain model class ContactGroupMapping.
 * @see com.sur.balaji.dao.ContactGroupMapping
 * @author Hibernate Tools
 */
@Repository("contactGroupMappingHome")
@Transactional
public class ContactGroupMappingHome {

    private static final Log log = LogFactory.getLog(ContactGroupMappingHome.class);

    //private final SessionFactory sessionFactory = getSessionFactory();
    @Autowired
	private SessionFactory sessionFactory;
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(ContactGroupMapping transientInstance) {
        log.debug("persisting ContactGroupMapping instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(ContactGroupMapping instance) {
        log.debug("attaching dirty ContactGroupMapping instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ContactGroupMapping instance) {
        log.debug("attaching clean ContactGroupMapping instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(ContactGroupMapping persistentInstance) {
        log.debug("deleting ContactGroupMapping instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ContactGroupMapping merge(ContactGroupMapping detachedInstance) {
        log.debug("merging ContactGroupMapping instance");
        try {
            ContactGroupMapping result = (ContactGroupMapping) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ContactGroupMapping findById( ContactGroupMappingId id) {
        log.debug("getting ContactGroupMapping instance with id: " + id);
        try {
            ContactGroupMapping instance = (ContactGroupMapping) sessionFactory.getCurrentSession()
                    .get("com.sur.balaji.model.ContactGroupMapping", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List<ContactGroupMapping> findByExample(ContactGroupMapping instance) {
        log.debug("finding ContactGroupMapping instance by example");
        try {
            List<ContactGroupMapping> results = (List<ContactGroupMapping>) sessionFactory.getCurrentSession()
                    .createCriteria("com.sur.balaji.model.ContactGroupMapping")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
}

