package com.pgr.springrest.SpringBootRestCRUDDemo.service;

import java.util.ArrayList;
import java.util.List;

import com.pgr.springrest.SpringBootRestCRUDDemo.dto.EmployeeDto;

public interface EmployeeService {

	public List<EmployeeDto> getListOfEmployee();

	public boolean addEmployee(EmployeeDto employee) throws Exception;

	public boolean updateEmployee(EmployeeDto employee, String empNo);
	
	public boolean updateMandatoryEmployeeData(EmployeeDto employee, String empNo);

	public boolean deleteEmployee(String empNo);

	public EmployeeDto getEmployeeDetailsById(String empNo);
	
	public boolean deleteMultipleEmployeesByEmpNo(ArrayList<String> empNo);
}
