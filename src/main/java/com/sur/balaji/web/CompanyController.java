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

import com.sur.balaji.dao.CompanyHome;
import com.sur.balaji.model.Company;
import com.sur.balaji.model.JSONResult;
import com.sur.balaji.model.JSONResult.Option;

import common.Status;

@Controller
@RequestMapping("/company")
public class CompanyController {

	protected final Log logger = LogFactory.getLog(getClass());
	private CompanyHome companyHome;
	private static final String VIEW = "company";

	@Autowired
	public void setCompanyHome(CompanyHome companyHome) {
		this.companyHome = companyHome;
	}

	/* CRUD operation - Add the company */
	@RequestMapping(value = "/companyListByFiter", method = RequestMethod.POST)
	public @ResponseBody JSONResult companyListByFiter(@ModelAttribute("SpringWeb") Company company) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("companyListByFiter() filter - " + company);
			List<Company> companyList = companyHome.findByExample(company);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecords(companyList);
			jsonResult.setTotalRecordCount(companyList.size());
		} catch (Exception ex) {
			logger.info("companyListByFiter() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("companyListByFiter() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/createCompany", method = RequestMethod.POST)
	public @ResponseBody JSONResult addCompany(@ModelAttribute("SpringWeb") Company company) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("add company - " + company);
			companyHome.persist(company);
			jsonResult.setResult(Status.OK);
			jsonResult.setRecord(company);
		} catch (Exception ex) {
			logger.info("addCompany() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("addCompany() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	public @ResponseBody JSONResult updateCompany(@ModelAttribute("SpringWeb") Company company) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("update company - " + company);
			Company updatedRecord = companyHome.merge(company);
			jsonResult.setResult(Status.OK);
			//jsonResult.setRecord(updatedRecord);
		} catch (Exception ex) {
			logger.info("updateCompany() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("updateCompany() returning " + jsonResult);
		return jsonResult;
	}

	@RequestMapping(value = "/deleteCompany", method = RequestMethod.POST)
	public @ResponseBody JSONResult deleteCompany(@ModelAttribute("SpringWeb") Company company) {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("delete company - " + company);
			Company record = companyHome.findById(company.getCompanyId());
			companyHome.delete(record);
			jsonResult.setResult(Status.OK);
		} catch (Exception ex) {
			logger.info("deleteCompany() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}

		logger.info("deleteCompany() returning " + jsonResult);
		return jsonResult;
	}
	
	@RequestMapping(value = "/companyOptions", method = RequestMethod.POST)
	public @ResponseBody JSONResult getCompanyOptions() {
		JSONResult jsonResult = new JSONResult();
		try {
			logger.info("getCompanyOptions() fetching all companys");
			Company company = new Company();
			List<Company> companyList = companyHome.findByExample(company);
			List<Option> options = new ArrayList<Option>();
			for(Company dept : companyList) {
				Option option = new Option(dept.getCompanyName(), dept.getCompanyId());
				options.add(option);
			}
			jsonResult.setResult(Status.OK);
			jsonResult.setOptions(options);
		} catch (Exception ex) {
			logger.info("getCompanyOptions() error: " + ex);
			jsonResult.setResult(Status.ERROR);
		}
		logger.info("getCompanyOptions() returning " + jsonResult);
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
