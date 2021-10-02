package com.pgr.sb.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pgr.sb.jdbc.bean.Employee;
import com.pgr.sb.jdbc.service.EmployeeService;

@SpringBootApplication
public class SbJdbcDemoApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SbJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeService.saveEmployee(new Employee(106, "PerlaReddy", 20000));
		/*
		 * boolean flag = employeeDao.saveEmployeeByPS(new Employee(104, "Mahesh",
		 * 90000)); System.out.println(flag);
		 */

		// List<Employee> list = employeeDao.getAllEmployees();
		// System.out.println(employeeDao.getEmployeeById(102));
		/*
		 * for(Employee emp : list) { System.out.println(emp); }
		 */
		// System.out.println(list);

		// employeeDao.udpateEmployeePS(new Employee(103, "Sai", 20000));

		employeeService.deleteEmployeePS(104);
	}

}
