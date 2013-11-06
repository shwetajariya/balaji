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

import com.sur.balaji.model.Department;

/**
 * Home object for domain model class Department.
 * @see com.sur.balaji.dao.Department
 * @author Hibernate Tools
 */
@Repository("departementHome")
@Transactional
public class DepartmentHome {

    private static final Log log = LogFactory.getLog(DepartmentHome.class);

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
    
    public void persist(Department transientInstance) {
        log.debug("persisting Department instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Department instance) {
        log.debug("attaching dirty Department instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Department instance) {
        log.debug("attaching clean Department instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Department persistentInstance) {
        log.debug("deleting Department instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Department merge(Department detachedInstance) {
        log.debug("merging Department instance");
        try {
            Department result = (Department) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Department findById( java.lang.Long id) {
        log.debug("getting Department instance with id: " + id);
        try {
            Department instance = (Department) sessionFactory.getCurrentSession()
                    .get("com.sur.balaji.model.Department", id);
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
    
    public List<Department> findByExample(Department instance) {
        log.debug("finding Department instance by example");
        try {
            List<Department> results = (List<Department>) sessionFactory.getCurrentSession()
                    .createCriteria("com.sur.balaji.model.Department")
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

