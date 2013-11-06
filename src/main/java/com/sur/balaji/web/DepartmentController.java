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

import com.sur.balaji.dao.DepartmentHome;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.Department;
import common.Status;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	protected final Log logger = LogFactory.getLog(getClass());
	private DepartmentHome departmentHome;
	private static final String VIEW = "department";

	@Autowired
	public void setDepartmentHome(DepartmentHome departmentHome) {
		this.departmentHome = departmentHome;
	}

	/* CRUD operation - Add the department */
	@RequestMapping(value = "/departmentListByFiter", method = RequestMethod.POST)
	public @ResponseBody JSONResult departmentListByFiter(@ModelAttribute("SpringWeb") Department department) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("departmentListByFiter() filter - " + department);
			List<Department> departmentList = departmentHome.findByExample(department);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecords(departmentList);
			jsonResult.setTotalRecordCount(departmentList.size());
		} catch (Exception ex) {
			logger.info("departmentListByFiter() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("departmentListByFiter() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
	public @ResponseBody JSONResult addDepartment(@ModelAttribute("SpringWeb") Department department) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add department - " + department);
			departmentHome.persist(department);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecord(department);
		} catch (Exception ex) {
			logger.info("addDepartment() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("addDepartment() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
	public @ResponseBody JSONResult updateDepartment(@ModelAttribute("SpringWeb") Department department) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update department - " + department);
			Department updatedRecord = departmentHome.merge(department);
			jsonResult.setResult(Status.OK);
			//jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateDepartment() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("updateDepartment() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
	public @ResponseBody JSONResult deleteDepartment(@ModelAttribute("SpringWeb") Department department) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete department - " + department);
			Department record = departmentHome.findById(department.getDepartmentId());
			departmentHome.delete(record);
			jsonResult.setResult(Status.OK);
		} catch (Exception ex) {
			logger.info("deleteDepartment() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("deleteDepartment() returning " + jsonResult);
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
