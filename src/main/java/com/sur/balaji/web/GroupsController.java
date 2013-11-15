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

import com.sur.balaji.dao.GroupsHome;
import com.sur.balaji.model.Groups;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.Groups;
import com.sur.balaji.model.JSONResult.Option;

import common.Status;

@Controller
@RequestMapping("/groups")
public class GroupsController {

	protected final Log logger = LogFactory.getLog(getClass());
	private GroupsHome groupsHome;
	private static final String VIEW = "groups";

	@Autowired
	public void setGroupsHome(GroupsHome groupsHome) {
		this.groupsHome = groupsHome;
	}

	/* CRUD operation - Add the groups */
	@RequestMapping(value = "/groupsListByFiter", method = RequestMethod.POST)
	public @ResponseBody JSONResult groupsListByFiter(@ModelAttribute("SpringWeb") Groups groups) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("groupsListByFiter() filter - " + groups);
			List<Groups> groupsList = groupsHome.findByExample(groups);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecords(groupsList);
			jsonResult.setTotalRecordCount(groupsList.size());
		} catch (Exception ex) {
			logger.info("groupsListByFiter() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("groupsListByFiter() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/groupsList", method = RequestMethod.GET)
	public @ResponseBody List<Groups> getGroupsList() {
		List<Groups> groupsList;
		try {
			Groups groups = new Groups();
			logger.info("groupsListByFiter() filter - " + groups);
			groupsList = groupsHome.findByExample(groups);
		} catch (Exception ex) {
			logger.info("groupsListByFiter() error: " + ex);
			groupsList = new ArrayList<Groups>();
		}
		logger.info("groupsListByFiter() returning " + groupsList);
		return groupsList;
	}
	
	@RequestMapping(value = "/createGroups", method = RequestMethod.POST)
	public @ResponseBody JSONResult addGroups(@ModelAttribute("SpringWeb") Groups groups) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add groups - " + groups);
			groupsHome.persist(groups);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecord(groups);
		} catch (Exception ex) {
			logger.info("addGroups() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("addGroups() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateGroups", method = RequestMethod.POST)
	public @ResponseBody JSONResult updateGroups(@ModelAttribute("SpringWeb") Groups groups) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update groups - " + groups);
			Groups updatedRecord = groupsHome.merge(groups);
			jsonResult.setResult(Status.OK);
			//jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateGroups() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("updateGroups() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteGroups", method = RequestMethod.POST)
	public @ResponseBody JSONResult deleteGroups(@ModelAttribute("SpringWeb") Groups groups) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete groups - " + groups);
			Groups record = groupsHome.findById(groups.getGroupId());
			groupsHome.delete(record);
			jsonResult.setResult(Status.OK);
		} catch (Exception ex) {
			logger.info("deleteGroups() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("deleteGroups() returning " + jsonResult);
		return jsonResult;
	}
	
	@RequestMapping(value = "/groupsOptions", method = RequestMethod.POST)
	public @ResponseBody JSONResult getGroupsOptions() {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("getGroupsOptions() fetching all groupss");
			Groups groups = new Groups();
			List<Groups> groupsList = groupsHome.findByExample(groups);
			List<Option> options = new ArrayList<Option>();
			for(Groups dept : groupsList) {
				Option option = new Option(dept.getGroupName(), dept.getGroupId());
				options.add(option);
			}
			jsonResult.setResult(Status.OK);
			jsonResult.setOptions(options);
		} catch (Exception ex) {
			logger.info("getGroupsOptions() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("getGroupsOptions() returning " + jsonResult);
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
