package com.sur.balaji.dao;
// Generated 7 Oct, 2013 7:45:54 PM by Hibernate Tools 4.0.0


import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.sur.balaji.model.Groups;

/**
 * Home object for domain model class Groups.
 * @see com.sur.balaji.dao.Groups
 * @author Hibernate Tools
 */
public class GroupsHome {

    private static final Log log = LogFactory.getLog(GroupsHome.class);

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
    
    public void persist(Groups transientInstance) {
        log.debug("persisting Groups instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Groups instance) {
        log.debug("attaching dirty Groups instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Groups instance) {
        log.debug("attaching clean Groups instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Groups persistentInstance) {
        log.debug("deleting Groups instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Groups merge(Groups detachedInstance) {
        log.debug("merging Groups instance");
        try {
            Groups result = (Groups) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Groups findById( java.lang.Long id) {
        log.debug("getting Groups instance with id: " + id);
        try {
            Groups instance = (Groups) sessionFactory.getCurrentSession()
                    .get("com.sur.balaji.dao.Groups", id);
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
    
    public List<Groups> findByExample(Groups instance) {
        log.debug("finding Groups instance by example");
        try {
            List<Groups> results = (List<Groups>) sessionFactory.getCurrentSession()
                    .createCriteria("com.sur.balaji.dao.Groups")
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

