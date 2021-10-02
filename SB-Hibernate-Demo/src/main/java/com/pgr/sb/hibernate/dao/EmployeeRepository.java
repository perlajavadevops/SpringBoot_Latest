package com.pgr.sb.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pgr.sb.hibernate.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Modifying
	@Query(value = "delete from employee_dummy where name= :name", nativeQuery = true)
	int deleteEmployeeByName(String name);

	@Query(value = "select * from employee_dummy where name= :name", nativeQuery = true)
	Employee findByName(String name);

}
