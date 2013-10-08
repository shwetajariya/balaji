package com.sur.balaji.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sur.balaji.dao.SectionHome;
import com.sur.balaji.model.Section;

public class TestDBConnection {

	public static void main(String[] args) {

		SectionHome sectionHome = new SectionHome();
		Section section = new Section();
		section.setSectionName("test_section");
		sectionHome.persist(section);
	}
}
