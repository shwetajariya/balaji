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

import com.sur.balaji.dao.MessageTemplateHome;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.MessageTemplate;
import common.Status;

@Controller
@RequestMapping("/messageTemplate")
public class MessageTemplateController {

	protected final Log logger = LogFactory.getLog(getClass());
	private MessageTemplateHome messageTemplateHome;
	private static final String VIEW = "messageTemplate";

	@Autowired
	public void setMessageTemplateHome(MessageTemplateHome messageTemplateHome) {
		this.messageTemplateHome = messageTemplateHome;
	}

	/* CRUD operation - Add the messageTemplate */
	@RequestMapping(value = "/messageTemplateListByFiter", method = RequestMethod.POST)
	public @ResponseBody JSONResult messageTemplateListByFiter(@ModelAttribute("SpringWeb") MessageTemplate messageTemplate) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("messageTemplateListByFiter() filter - " + messageTemplate);
			List<MessageTemplate> messageTemplateList = messageTemplateHome.findByExample(messageTemplate);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecords(messageTemplateList);
			jsonResult.setTotalRecordCount(messageTemplateList.size());
		} catch (Exception ex) {
			logger.info("messageTemplateListByFiter() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("messageTemplateListByFiter() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/createMessageTemplate", method = RequestMethod.POST)
	public @ResponseBody JSONResult addMessageTemplate(@ModelAttribute("SpringWeb") MessageTemplate messageTemplate) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add messageTemplate - " + messageTemplate);
			messageTemplateHome.persist(messageTemplate);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecord(messageTemplate);
		} catch (Exception ex) {
			logger.info("addMessageTemplate() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("addMessageTemplate() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateMessageTemplate", method = RequestMethod.POST)
	public @ResponseBody JSONResult updateMessageTemplate(@ModelAttribute("SpringWeb") MessageTemplate messageTemplate) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update messageTemplate - " + messageTemplate);
			MessageTemplate updatedRecord = messageTemplateHome.merge(messageTemplate);
			jsonResult.setResult(Status.OK);
			//jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateMessageTemplate() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("updateMessageTemplate() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteMessageTemplate", method = RequestMethod.POST)
	public @ResponseBody JSONResult deleteMessageTemplate(@ModelAttribute("SpringWeb") MessageTemplate messageTemplate) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete messageTemplate - " + messageTemplate);
			MessageTemplate record = messageTemplateHome.findById(messageTemplate.getTemplateId());
			messageTemplateHome.delete(record);
			jsonResult.setResult(Status.OK);
		} catch (Exception ex) {
			logger.info("deleteMessageTemplate() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("deleteMessageTemplate() returning " + jsonResult);
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
