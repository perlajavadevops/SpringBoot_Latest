package com.pgr.sb.hibernate.service;

import java.util.List;

import com.pgr.sb.hibernate.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeByName(String ssn);

	Employee findByName(String ssn);

	void updateEmployee(Employee employee);
}
