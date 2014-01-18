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

import com.sur.balaji.model.Designation;

/**
 * Home object for domain model class Designation.
 * 
 * @see com.sur.balaji.dao.Designation
 * @author Hibernate Tools
 */
@Repository("designationHome")
@Transactional
public class DesignationHome {

	private static final Log log = LogFactory.getLog(DesignationHome.class);

	// private final SessionFactory sessionFactory = getSessionFactory();
	@Autowired
	private SessionFactory sessionFactory;

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Designation transientInstance) {
		log.debug("persisting Designation instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Designation instance) {
		log.debug("attaching dirty Designation instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Designation instance) {
		log.debug("attaching clean Designation instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Designation persistentInstance) {
		log.debug("deleting Designation instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Designation merge(Designation detachedInstance) {
		log.debug("merging Designation instance");
		try {
			Designation result = (Designation) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Designation findById(java.lang.Long id) {
		log.debug("getting Designation instance with id: " + id);
		try {
			Designation instance = (Designation) sessionFactory
					.getCurrentSession().get(
							"com.sur.balaji.model.Designation", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Designation> findByExample(Designation instance) {
		log.debug("finding Designation instance by example");
		try {
			List<Designation> results = (List<Designation>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.sur.balaji.model.Designation")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
