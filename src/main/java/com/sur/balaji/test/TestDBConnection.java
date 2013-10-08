package com.sur.balaji.test;

import com.sur.balaji.dao.SectionHome;
import com.sur.balaji.model.Section;

public class TestDBConnection {

	public static void main(String[] args) {

		// TODO: for this test to run, update home to create session from new configuration...
		SectionHome sectionHome = new SectionHome();
		Section section = new Section();
		section.setSectionName("test_section");
		sectionHome.persist(section);
	}
}
