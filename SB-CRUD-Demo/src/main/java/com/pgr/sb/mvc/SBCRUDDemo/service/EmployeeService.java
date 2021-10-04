package com.pgr.sb.mvc.SBCRUDDemo.service;


import java.util.List;

import com.pgr.sb.mvc.SBCRUDDemo.dto.EmployeeDto;


public interface EmployeeService {
	
	public List<EmployeeDto> getListOfEmployee();

	public boolean addEmployee(EmployeeDto employee);

	public boolean updateEmployee(EmployeeDto employee);

	public boolean deleteEmployee(String empNo);
}
