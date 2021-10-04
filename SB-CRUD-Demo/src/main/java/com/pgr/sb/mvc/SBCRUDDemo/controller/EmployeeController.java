package com.pgr.sb.mvc.SBCRUDDemo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pgr.sb.mvc.SBCRUDDemo.dto.EmployeeDto;
import com.pgr.sb.mvc.SBCRUDDemo.service.EmployeeService;

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

	@ResponseBody
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(EmployeeDto employee) {
		System.out.println(employee.getFirstName());
		String msg = "Error occured while updating employee: " + employee.getFirstName() + ", " + employee.getLastName()
				+ ",  please try again";
		try {
			if (employee != null) {
				boolean flag = employeeService.updateEmployee(employee);
				if (flag) {
					msg = "Employee ID: " + employee.getEmpNo() + " details updated successfully...";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployeePage() {
		System.out.println("deleteEmployee page loaded...");
		ModelAndView view = new ModelAndView("deleteEmployee");
		view.addObject("empList", employeeService.getListOfEmployee());
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmployee(String empNo) {
		System.out.println("inside delete");
		String msg = "Error occured while deleting employee: " + empNo;
		try {
			if (empNo != null) {
				boolean flag = employeeService.deleteEmployee(empNo);
				if (flag) {
					msg = "Employee ID: " + empNo + " deleted successfully...";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}
}