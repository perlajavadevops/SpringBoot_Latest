package com.pgr.sb.mvc.SBCRUDDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pgr.sb.mvc.SBCRUDDemo.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

	@Modifying
	@Query(value = "delete from employee_details_1 where emp_no= :empNo", nativeQuery = true)
	boolean deleteEmployeeByEmpNo(String empNo);


}
