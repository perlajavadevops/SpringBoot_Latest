package com.pgr.sb.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgr.sb.hibernate.dao.EmployeeRepository;
import com.pgr.sb.hibernate.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	public void deleteEmployeeByName(String name) {
		employeeRepository.deleteEmployeeByName(name);
	}

	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
}
