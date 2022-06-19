package com.pgr.springrest.SpringBootRestCRUDDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgr.springrest.SpringBootRestCRUDDemo.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

	@Transactional
	@Modifying
	@Query(value = "delete from employee_details_b3 where emp_no= :empNo", nativeQuery = true)
	int deleteEmployeeByEmpNo(String empNo);
	
	//deleting bulk records
	@Transactional
	@Modifying
	@Query(value = "delete from employee_details_b3 where emp_no in (:empNo)", nativeQuery = true)
	int deleteMultipleEmployeesByEmpNo(List<String> empNo);
	
	@Transactional
	@Modifying
	@Query(value = "update EmployeeEntity set designation=:desi, phone=:phone where emp_no= :empNo", nativeQuery = true)
	boolean updateEmployee(String empNo, @Param("desi") String designation, @Param("ph") String phone);

	@Query(value = "FROM EmployeeEntity WHERE empNo= :empNo", nativeQuery = false)//named queries
	//@Query(value = "select * from employee_details_b3 where emp_no= :empNo", nativeQuery = true)
	EmployeeEntity getEmployeeDetailsById(String empNo);

	
}
