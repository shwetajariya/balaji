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

import com.sur.balaji.model.MessageTemplate;

/**
 * Home object for domain model class MessageTemplate.
 * 
 * @see com.sur.balaji.dao.MessageTemplate
 * @author Hibernate Tools
 */
@Repository("messageTemplateHome")
@Transactional
public class MessageTemplateHome {

	private static final Log log = LogFactory.getLog(MessageTemplateHome.class);

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

	public void persist(MessageTemplate transientInstance) {
		log.debug("persisting MessageTemplate instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MessageTemplate instance) {
		log.debug("attaching dirty MessageTemplate instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MessageTemplate instance) {
		log.debug("attaching clean MessageTemplate instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MessageTemplate persistentInstance) {
		log.debug("deleting MessageTemplate instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MessageTemplate merge(MessageTemplate detachedInstance) {
		log.debug("merging MessageTemplate instance");
		try {
			MessageTemplate result = (MessageTemplate) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MessageTemplate findById(java.lang.Long id) {
		log.debug("getting MessageTemplate instance with id: " + id);
		try {
			MessageTemplate instance = (MessageTemplate) sessionFactory
					.getCurrentSession().get(
							"com.sur.balaji.model.MessageTemplate", id);
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

	public List<MessageTemplate> findByExample(MessageTemplate instance) {
		log.debug("finding MessageTemplate instance by example");
		try {
			List<MessageTemplate> results = (List<MessageTemplate>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.sur.balaji.model.MessageTemplate")
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
