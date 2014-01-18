package com.sur.balaji.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HomeBase {

	private static final Log log = LogFactory.getLog(UserHome.class);
	// private static final SessionFactory sessionFactory =
	// buildSessionFactory();
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration conf = new Configuration();
			conf.configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(conf.getProperties()).buildServiceRegistry();
			SessionFactory sessionFactory = conf
					.buildSessionFactory(serviceRegistry);

			return sessionFactory;

		} catch (Exception e) {

			log.error("Initial SessionFactory creation failed." + e);
			throw new IllegalStateException(
					"Initial Session Factory creation failed.");
		}
	}

	public static SessionFactory getSessionFactory1() {
		return sessionFactory;
	}
}
