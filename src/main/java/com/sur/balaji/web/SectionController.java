package com.sur.balaji.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sur.balaji.dao.SectionHome;
import com.sur.balaji.model.Section;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.Section;
import com.sur.balaji.model.JSONResult.Option;

import common.Status;

@Controller
@RequestMapping("/section")
public class SectionController {

	protected final Log logger = LogFactory.getLog(getClass());
	private SectionHome sectionHome;
	private static final String VIEW = "section";

	@Autowired
	public void setSectionHome(SectionHome sectionHome) {
		this.sectionHome = sectionHome;
	}

	/* CRUD operation - Add the section */
	@RequestMapping(value = "/sectionListByFiter", method = RequestMethod.POST)
	public @ResponseBody JSONResult sectionListByFiter(@ModelAttribute("SpringWeb") Section section) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("sectionListByFiter() filter - " + section);
			List<Section> sectionList = sectionHome.findByExample(section);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecords(sectionList);
			jsonResult.setTotalRecordCount(sectionList.size());
		} catch (Exception ex) {
			logger.info("sectionListByFiter() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("sectionListByFiter() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/createSection", method = RequestMethod.POST)
	public @ResponseBody JSONResult addSection(@ModelAttribute("SpringWeb") Section section) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add section - " + section);
			sectionHome.persist(section);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecord(section);
		} catch (Exception ex) {
			logger.info("addSection() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("addSection() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateSection", method = RequestMethod.POST)
	public @ResponseBody JSONResult updateSection(@ModelAttribute("SpringWeb") Section section) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update section - " + section);
			Section updatedRecord = sectionHome.merge(section);
			jsonResult.setResult(Status.OK);
			//jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateSection() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("updateSection() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteSection", method = RequestMethod.POST)
	public @ResponseBody JSONResult deleteSection(@ModelAttribute("SpringWeb") Section section) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete section - " + section);
			Section record = sectionHome.findById(section.getSectionId());
			sectionHome.delete(record);
			jsonResult.setResult(Status.OK);
		} catch (Exception ex) {
			logger.info("deleteSection() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("deleteSection() returning " + jsonResult);
		return jsonResult;
	}
	
	@RequestMapping(value = "/sectionOptions", method = RequestMethod.POST)
	public @ResponseBody JSONResult getSectionOptions() {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("getSectionOptions() fetching all sections");
			Section section = new Section();
			List<Section> sectionList = sectionHome.findByExample(section);
			List<Option> options = new ArrayList<Option>();
			for(Section dept : sectionList) {
				Option option = new Option(dept.getSectionName(), dept.getSectionId());
				options.add(option);
			}
			jsonResult.setResult(Status.OK);
			jsonResult.setOptions(options);
		} catch (Exception ex) {
			logger.info("getSectionOptions() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("getSectionOptions() returning " + jsonResult);
		return jsonResult;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String get(ModelMap model) {

		logger.info("get method called...");
		model.addAttribute("status", Status.OK);
		model.addAttribute("message", Status.OK);
		return VIEW;
	}
}
