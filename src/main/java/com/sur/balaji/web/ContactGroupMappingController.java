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

import com.sur.balaji.dao.ContactGroupMappingHome;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.ContactGroupMapping;
import common.Status;

@Controller
@RequestMapping("/contactGroupMapping")
public class ContactGroupMappingController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ContactGroupMappingHome contactGroupMappingHome;
	private static final String VIEW = "contactGroupMapping";

	@Autowired
	public void setContactGroupMappingHome(ContactGroupMappingHome contactGroupMappingHome) {
		this.contactGroupMappingHome = contactGroupMappingHome;
	}

	/* CRUD operation - Add the contactGroupMapping */
	@RequestMapping(value = "/contactGroupMappingListByFiter", method = RequestMethod.POST)
	public @ResponseBody JSONResult contactGroupMappingListByFiter(@ModelAttribute("SpringWeb") ContactGroupMapping contactGroupMapping) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("contactGroupMappingListByFiter() filter - " + contactGroupMapping);
			List<ContactGroupMapping> contactGroupMappingList = contactGroupMappingHome.findByExample(contactGroupMapping);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecords(contactGroupMappingList);
			jsonResult.setTotalRecordCount(contactGroupMappingList.size());
		} catch (Exception ex) {
			logger.info("contactGroupMappingListByFiter() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("contactGroupMappingListByFiter() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/createContactGroupMapping", method = RequestMethod.POST)
	public @ResponseBody JSONResult addContactGroupMapping(@ModelAttribute("SpringWeb") ContactGroupMapping contactGroupMapping) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add contactGroupMapping - " + contactGroupMapping);
			contactGroupMappingHome.persist(contactGroupMapping);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecord(contactGroupMapping);
		} catch (Exception ex) {
			logger.info("addContactGroupMapping() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("addContactGroupMapping() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateContactGroupMapping", method = RequestMethod.POST)
	public @ResponseBody JSONResult updateContactGroupMapping(@ModelAttribute("SpringWeb") ContactGroupMapping contactGroupMapping) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update contactGroupMapping - " + contactGroupMapping);
			ContactGroupMapping updatedRecord = contactGroupMappingHome.merge(contactGroupMapping);
			jsonResult.setResult(Status.OK);
			//jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateContactGroupMapping() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("updateContactGroupMapping() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteContactGroupMapping", method = RequestMethod.POST)
	public @ResponseBody JSONResult deleteContactGroupMapping(@ModelAttribute("SpringWeb") ContactGroupMapping contactGroupMapping) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete contactGroupMapping - " + contactGroupMapping);
			ContactGroupMapping record = contactGroupMappingHome.findById(contactGroupMapping.getId());
			contactGroupMappingHome.delete(record);
			jsonResult.setResult(Status.OK);
		} catch (Exception ex) {
			logger.info("deleteContactGroupMapping() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("deleteContactGroupMapping() returning " + jsonResult);
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
