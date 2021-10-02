package com.pgr.sb.hibernate;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pgr.sb.hibernate.model.Employee;
import com.pgr.sb.hibernate.service.EmployeeService;

@SpringBootApplication
public class SbHibernateDemoApplication implements CommandLineRunner  {

	@Autowired
	EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(SbHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee();
		employee1.setName("SivaReddy");
		employee1.setJoiningDate(new Date());
		employee1.setSalary(new BigDecimal(30000));
		
		employeeService.saveEmployee(employee1);
		System.out.println(employeeService.findByName("PerlaReddy"));
		//employeeService.deleteEmployeeByName("Sirisha");
	} 

}
