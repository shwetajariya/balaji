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

import com.sur.balaji.dao.UserHome;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.User;

import common.Response;

@Controller
@RequestMapping("/user")
public class UserController {

	protected final Log logger = LogFactory.getLog(getClass());
	private UserHome userHome;
	private static final String VIEW = "user";

	@Autowired
	public void setUserHome(UserHome userHome) {
		this.userHome = userHome;
	}

	/* CRUD operation - Add the user */
	@RequestMapping(value = "/userListByFiter", method = RequestMethod.POST)
	public @ResponseBody
	JSONResult userListByFiter(@ModelAttribute("SpringWeb") User user) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("userListByFiter() filter - " + user);
			List<User> userList = userHome.findByExample(user);
			jsonResult.setResult(Response.OK);
			jsonResult.setRecords(userList);
			jsonResult.setTotalRecordCount(userList.size());
		} catch (Exception ex) {
			logger.info("userListByFiter() error: " + ex);
			jsonResult.setResult(Response.ERROR);
		}
		logger.info("userListByFiter() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody
	JSONResult addUser(@ModelAttribute("SpringWeb") User user) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add user - " + user);
			userHome.persist(user);
			jsonResult.setResult(Response.OK);
			jsonResult.setRecord(user);
		} catch (Exception ex) {
			logger.info("addUser() error: " + ex);
			jsonResult.setResult(Response.ERROR);
		}

		logger.info("addUser() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody
	JSONResult updateUser(@ModelAttribute("SpringWeb") User user) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update user - " + user);
			User updatedRecord = userHome.merge(user);
			jsonResult.setResult(Response.OK);
			// jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateUser() error: " + ex);
			jsonResult.setResult(Response.ERROR);
		}

		logger.info("updateUser() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody
	JSONResult deleteUser(@ModelAttribute("SpringWeb") User user) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete user - " + user);
			User record = userHome.findById(user.getUserId());
			userHome.delete(record);
			jsonResult.setResult(Response.OK);
		} catch (Exception ex) {
			logger.info("deleteUser() error: " + ex);
			jsonResult.setResult(Response.ERROR);
		}

		logger.info("deleteUser() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String get(ModelMap model) {

		logger.info("get method called...");
		model.addAttribute("status", Response.OK);
		model.addAttribute("message", Response.OK);
		return VIEW;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome(ModelMap model) {

		logger.info("get method called...");
		model.addAttribute("status", Response.OK);
		model.addAttribute("message", Response.OK);
		return "home";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public User loginUser(@ModelAttribute("SpringWeb") User user) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("login user - " + user);
			User record = userHome.findById(user.getUserId());
			if (null != record) {
				if (!user.getPassword().equals(record.getPassword())) {
					user = null;
					logger.info("Password didn't match");
					jsonResult.setResult(Response.EXCEPTION);
					throw new Exception("Given password didn't match.");
				}
			} else {
				logger.info("User not found.");
				jsonResult.setResult(Response.EXCEPTION);
				throw new Exception("Password didn't match.");
			}
			jsonResult.setResult(Response.OK);

		} catch (Exception ex) {
			logger.info("loginUser() error: " + ex);
			jsonResult.setResult(Response.ERROR);
		}

		logger.info("loginUser() returning " + jsonResult);
		return user;
	}

}
