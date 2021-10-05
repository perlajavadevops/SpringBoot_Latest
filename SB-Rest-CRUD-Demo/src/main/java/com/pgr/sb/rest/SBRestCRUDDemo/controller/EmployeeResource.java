package com.pgr.sb.rest.SBRestCRUDDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgr.sb.rest.SBRestCRUDDemo.dto.EmployeeDto;
import com.pgr.sb.rest.SBRestCRUDDemo.service.EmployeeService;


@RestController
public class EmployeeResource {

	@Autowired
	public EmployeeService employeeService;

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
