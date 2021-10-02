package com.pgr.sb.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgr.sb.jdbc.bean.Employee;
import com.pgr.sb.jdbc.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	public boolean udpateEmployeePS(Employee employee) {
		return employeeDao.udpateEmployeePS(employee);
	}

	@Override
	public boolean deleteEmployeePS(int empno) {

		return employeeDao.deleteEmployeePS(empno);
	}

	@Override
	public boolean saveEmployeeByPS(Employee employee) {
		return employeeDao.saveEmployeeByPS(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public List<Employee> getEmployeeById(int empno) {
		return employeeDao.getEmployeeById(empno);
	}

}
