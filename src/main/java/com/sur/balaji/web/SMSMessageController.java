package com.sur.balaji.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sur.balaji.dao.ContactHome;
import com.sur.balaji.dao.GroupsHome;
import com.sur.balaji.model.Contact;
import com.sur.balaji.model.Groups;
import com.sur.balaji.model.SMSMessage;
import com.sur.balaji.model.Section;

import common.Status;

@Controller
@RequestMapping("/smsMessage")
public class SMSMessageController {

	protected final Log logger = LogFactory.getLog(getClass());
	private ContactHome contactHome;
	private GroupsHome groupsHome;
	private static final String VIEW = "smsMessage";

	@Autowired
	public void setContactHome(ContactHome contactHome) {
		this.contactHome = contactHome;
	}
	
	@Autowired
	public void setGroupsHome(GroupsHome groupsHome) {
		this.groupsHome = groupsHome;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String get(ModelMap model) {

		logger.info("get method called...");
		List<Contact> contactList = contactHome.findByExample(new Contact());
		List<Groups> groupsList = groupsHome.findByExample(new Groups());
		model.addAttribute("contacts", contactList);
		model.addAttribute("groups", groupsList);
		model.addAttribute("status", Status.OK);
		model.addAttribute("message", Status.OK);
		return VIEW;
	}
	
	@RequestMapping(value = "/sendSMSMessage", method = RequestMethod.GET)
	public String sendSMSMessage(@ModelAttribute("SpringWeb") SMSMessage smsMessage) {

		logger.info("sendSMSMessage method called..., smsMessage=" + smsMessage);
		
		return VIEW;
	}
}
