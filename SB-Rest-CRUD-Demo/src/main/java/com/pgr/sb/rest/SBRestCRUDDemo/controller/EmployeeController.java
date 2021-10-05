package com.pgr.sb.rest.SBRestCRUDDemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pgr.sb.rest.SBRestCRUDDemo.dto.EmployeeDto;
import com.pgr.sb.rest.SBRestCRUDDemo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView test() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public ModelAndView listOfEmployee() {
		List<EmployeeDto> employeeList = employeeService.getListOfEmployee();
		System.out.println(employeeList.toString());
		System.out.println(employeeList.size());
		ModelAndView view = new ModelAndView("listOfEmployee");
		view.addObject("empList", employeeList);
		return view;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployeePage() {
		System.out.println("addEmployee page loaded...");
		ModelAndView view = new ModelAndView("addEmployee");
		return view;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(EmployeeDto employee) {
		boolean flag = employeeService.addEmployee(employee);
		System.out.println("Flag: " + flag);
		ModelAndView view = new ModelAndView("addEmployee");
		if (flag) {
			view.addObject("msg",
					"Employee " + employee.getFirstName() + ", " + employee.getLastName() + " added successfully...");
		} else {
			view.addObject("msg", "Error occured while registering employee, please try again...");
		}
		return view;
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public ModelAndView updateEmployeePage() {
		System.out.println("updateEmployee page loaded...");
		ModelAndView view = new ModelAndView("updateEmployee");
		view.addObject("empList", employeeService.getListOfEmployee());
		return view;
	}

	

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployeePage() {
		System.out.println("deleteEmployee page loaded...");
		ModelAndView view = new ModelAndView("deleteEmployee");
		view.addObject("empList", employeeService.getListOfEmployee());
		return view;
	}
}