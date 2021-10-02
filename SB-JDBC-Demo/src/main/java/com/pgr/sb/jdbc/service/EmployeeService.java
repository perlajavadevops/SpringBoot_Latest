package com.pgr.sb.jdbc.service;

import java.util.List;

import com.pgr.sb.jdbc.bean.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);

	public boolean udpateEmployeePS(Employee employee);

	public boolean deleteEmployeePS(int empno);

	public boolean saveEmployeeByPS(Employee employee);

	public List<Employee> getAllEmployees();

	public List<Employee> getEmployeeById(int empno);
}
