package com.pgr.sb.rest.SBRestCRUDDemo.service;


import java.util.List;

import com.pgr.sb.rest.SBRestCRUDDemo.dto.EmployeeDto;


public interface EmployeeService {
	
	public List<EmployeeDto> getListOfEmployee();

	public boolean addEmployee(EmployeeDto employee);

	public boolean updateEmployee(EmployeeDto employee);

	public boolean deleteEmployee(String empNo);
}
