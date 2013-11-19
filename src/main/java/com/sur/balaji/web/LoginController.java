package com.sur.balaji.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sur.balaji.dao.UserHome;
import com.sur.balaji.model.User;

import common.Response;

@Controller
@RequestMapping("/login")
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());
	private UserHome userHome;
	private static final String VIEW = "login";
	private static final String HOME_VIEW = "contact";

	@Autowired
	public void setUserHome(UserHome userHome) {
		this.userHome = userHome;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("SpringWeb") User user,
			HttpSession session, ModelMap model) {
		try {
			logger.info("login user - " + user);
			User queryParam = new User();
			queryParam.setLoginName(user.getLoginName());
			List<User> records = userHome.findByExample(queryParam);
			if (null != records && records.size()>0) {
				User record = records.get(0);
				if (!(user.getPassword().equals(record.getPassword()))) {
					user = null;
					logger.info("Password didn't match");
					throw new Exception("Password didn't match.");
				}
				else{
					session.setAttribute("loggedin_user", user);
					model.addAttribute("status", Response.OK);
					return HOME_VIEW;
				}
			} else {
				logger.info("User not found.");
				throw new Exception("User not found.");
			}
		} catch (Exception ex) {
			logger.info("loginUser() error: " + ex);
			model.addAttribute("status", Response.ERROR);
			model.addAttribute("message", ex.getMessage());
		}
		return VIEW;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String get(ModelMap model) {

		logger.info("get method of LoginController called...");
		model.addAttribute("status", Response.OK);
		return VIEW;
	}
}
