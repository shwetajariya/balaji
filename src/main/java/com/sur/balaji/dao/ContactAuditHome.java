package com.sur.balaji.dao;
// Generated 7 Oct, 2013 7:45:54 PM by Hibernate Tools 4.0.0


import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.sur.balaji.model.ContactAudit;
import com.sur.balaji.model.ContactAuditId;

/**
 * Home object for domain model class ContactAudit.
 * @see com.sur.balaji.dao.ContactAudit
 * @author Hibernate Tools
 */
public class ContactAuditHome {

    private static final Log log = LogFactory.getLog(ContactAuditHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(ContactAudit transientInstance) {
        log.debug("persisting ContactAudit instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(ContactAudit instance) {
        log.debug("attaching dirty ContactAudit instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ContactAudit instance) {
        log.debug("attaching clean ContactAudit instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(ContactAudit persistentInstance) {
        log.debug("deleting ContactAudit instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ContactAudit merge(ContactAudit detachedInstance) {
        log.debug("merging ContactAudit instance");
        try {
            ContactAudit result = (ContactAudit) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ContactAudit findById( ContactAuditId id) {
        log.debug("getting ContactAudit instance with id: " + id);
        try {
            ContactAudit instance = (ContactAudit) sessionFactory.getCurrentSession()
                    .get("com.sur.balaji.dao.ContactAudit", id);
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
    
    public List<ContactAudit> findByExample(ContactAudit instance) {
        log.debug("finding ContactAudit instance by example");
        try {
            List<ContactAudit> results = (List<ContactAudit>) sessionFactory.getCurrentSession()
                    .createCriteria("com.sur.balaji.dao.ContactAudit")
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

