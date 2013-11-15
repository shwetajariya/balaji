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

import com.sur.balaji.dao.ContactHome;
import com.sur.balaji.model.Contact;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.Contact;
import com.sur.balaji.model.JSONResult.Option;

import common.Status;

@Controller
@RequestMapping("/contact")
public class ContactController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ContactHome contactHome;
	private static final String VIEW = "contact";

	@Autowired
	public void setContactHome(ContactHome contactHome) {
		this.contactHome = contactHome;
	}

	/* CRUD operation - Add the contact */
	@RequestMapping(value = "/contactListByFiter", method = RequestMethod.POST)
	public @ResponseBody JSONResult contactListByFiter(@ModelAttribute("SpringWeb") Contact contact) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("contactListByFiter() filter - " + contact);
			List<Contact> contactList = contactHome.findByExample(contact);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecords(contactList);
			jsonResult.setTotalRecordCount(contactList.size());
		} catch (Exception ex) {
			logger.info("contactListByFiter() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("contactListByFiter() returning " + jsonResult);
		return jsonResult;
	}
	
	@RequestMapping(value = "/contactList", method = RequestMethod.GET)
	public @ResponseBody List<Contact> getContactList() {
		List<Contact> contactList;
		try {
			Contact contact = new Contact();
			logger.info("contactListByFiter() filter - " + contact);
			contactList = contactHome.findByExample(contact);
		} catch (Exception ex) {
			logger.info("contactListByFiter() error: " + ex);
			contactList = new ArrayList<Contact>();
		}
		logger.info("contactList() returning " + contactList );
		return contactList;
	}

	@RequestMapping(value = "/createContact", method = RequestMethod.POST)
	public @ResponseBody JSONResult addContact(@ModelAttribute("SpringWeb") Contact contact) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add contact - " + contact);
			contactHome.persist(contact);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecord(contact);
		} catch (Exception ex) {
			logger.info("addContact() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("addContact() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateContact", method = RequestMethod.POST)
	public @ResponseBody JSONResult updateContact(@ModelAttribute("SpringWeb") Contact contact) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update contact - " + contact);
			Contact updatedRecord = contactHome.merge(contact);
			jsonResult.setResult(Status.OK);
			//jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateContact() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("updateContact() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
	public @ResponseBody JSONResult deleteContact(@ModelAttribute("SpringWeb") Contact contact) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete contact - " + contact);
			Contact record = contactHome.findById(contact.getContactId());
			contactHome.delete(record);
			jsonResult.setResult(Status.OK);
		} catch (Exception ex) {
			logger.info("deleteContact() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("deleteContact() returning " + jsonResult);
		return jsonResult;
	}
	
	@RequestMapping(value = "/contactOptions", method = RequestMethod.POST)
	public @ResponseBody JSONResult getContactOptions() {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("getContactOptions() fetching all contacts");
			Contact contact = new Contact();
			List<Contact> contactList = contactHome.findByExample(contact);
			List<Option> options = new ArrayList<Option>();
			for(Contact dept : contactList) {
				Option option = new Option(dept.getContactName(), dept.getContactId());
				options.add(option);
			}
			jsonResult.setResult(Status.OK);
			jsonResult.setOptions(options);
		} catch (Exception ex) {
			logger.info("getContactOptions() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("getContactOptions() returning " + jsonResult);
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
