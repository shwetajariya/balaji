package com.sur.balaji.web;

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

import com.sur.balaji.dao.DesignationHome;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.Designation;
import common.Status;

@Controller
@RequestMapping("/designation")
public class DesignationController {

	protected final Log logger = LogFactory.getLog(getClass());
	private DesignationHome designationHome;
	private static final String VIEW = "designation";

	@Autowired
	public void setDesignationHome(DesignationHome designationHome) {
		this.designationHome = designationHome;
	}

	/* CRUD operation - Add the designation */
	@RequestMapping(value = "/designationListByFiter", method = RequestMethod.POST)
	public @ResponseBody JSONResult designationListByFiter(@ModelAttribute("SpringWeb") Designation designation) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("designationListByFiter() filter - " + designation);
			List<Designation> designationList = designationHome.findByExample(designation);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecords(designationList);
			jsonResult.setTotalRecordCount(designationList.size());
		} catch (Exception ex) {
			logger.info("designationListByFiter() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("designationListByFiter() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/createDesignation", method = RequestMethod.POST)
	public @ResponseBody JSONResult addDesignation(@ModelAttribute("SpringWeb") Designation designation) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add designation - " + designation);
			designationHome.persist(designation);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecord(designation);
		} catch (Exception ex) {
			logger.info("addDesignation() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("addDesignation() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateDesignation", method = RequestMethod.POST)
	public @ResponseBody JSONResult updateDesignation(@ModelAttribute("SpringWeb") Designation designation) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update designation - " + designation);
			Designation updatedRecord = designationHome.merge(designation);
			jsonResult.setResult(Status.OK);
			//jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateDesignation() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("updateDesignation() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteDesignation", method = RequestMethod.POST)
	public @ResponseBody JSONResult deleteDesignation(@ModelAttribute("SpringWeb") Designation designation) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete designation - " + designation);
			Designation record = designationHome.findById(designation.getDesignationId());
			designationHome.delete(record);
			jsonResult.setResult(Status.OK);
		} catch (Exception ex) {
			logger.info("deleteDesignation() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("deleteDesignation() returning " + jsonResult);
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
