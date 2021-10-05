package com.pgr.sb.mvc.SBCRUDDemoWebJars.service;


import java.util.List;

import com.pgr.sb.mvc.SBCRUDDemoWebJars.dto.EmployeeDto;


public interface EmployeeService {
	
	public List<EmployeeDto> getListOfEmployee();

	public boolean addEmployee(EmployeeDto employee);

	public boolean updateEmployee(EmployeeDto employee);

	public boolean deleteEmployee(String empNo);
}
