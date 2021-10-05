package com.pgr.sb.mvc.SBCRUDDemoWebJars.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgr.sb.mvc.SBCRUDDemoWebJars.dto.EmployeeDto;
import com.pgr.sb.mvc.SBCRUDDemoWebJars.entity.EmployeeEntity;
import com.pgr.sb.mvc.SBCRUDDemoWebJars.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	public List<EmployeeDto> getListOfEmployee() {
		List<EmployeeDto> employeesList = new ArrayList<>();

		List<EmployeeEntity> employees = employeeRepository.findAll();
		for (EmployeeEntity entity : employees) {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setId(entity.getId());
			employeeDto.setEmpNo(entity.getEmpNo());
			employeeDto.setFirstName(entity.getFirstName());
			employeeDto.setLastName(entity.getLastName());
			employeeDto.setDeptName(entity.getDeptName());
			employeeDto.setDesignation(entity.getDesignation());
			employeeDto.setSalary(entity.getSalary());
			employeeDto.setBranch(entity.getBranch());
			employeeDto.setCountry(entity.getCountry());
			employeeDto.setGender(entity.getGender());
			employeeDto.setPassword(entity.getPassword());
			employeeDto.setEmail(entity.getEmail());
			employeeDto.setPhone(entity.getPhone());
			employeeDto.setDop(entity.getDop());

			employeesList.add(employeeDto);

		}
		return employeesList;
	}

	public boolean addEmployee(EmployeeDto employeeDto) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(employeeDto.getId());
		employeeEntity.setEmpNo(employeeDto.getEmpNo());
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setDeptName(employeeDto.getDeptName());
		employeeEntity.setDesignation(employeeDto.getDesignation());
		employeeEntity.setSalary(employeeDto.getSalary());
		employeeEntity.setBranch(employeeDto.getBranch());
		employeeEntity.setCountry(employeeDto.getCountry());
		employeeEntity.setGender(employeeDto.getGender());
		employeeEntity.setPassword(employeeDto.getPassword());
		employeeEntity.setEmail(employeeDto.getEmail());
		employeeEntity.setPhone(employeeDto.getPhone());
		employeeEntity.setDop(employeeDto.getDop());
		
		EmployeeEntity entity = employeeRepository.save(employeeEntity);
		if(entity!=null)
			return true;
		else
			return false;
	}

	public boolean updateEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(employeeDto.getId());
		employeeEntity.setEmpNo(employeeDto.getEmpNo());
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setDeptName(employeeDto.getDeptName());
		employeeEntity.setDesignation(employeeDto.getDesignation());
		employeeEntity.setSalary(employeeDto.getSalary());
		employeeEntity.setBranch(employeeDto.getBranch());
		employeeEntity.setCountry(employeeDto.getCountry());
		employeeEntity.setGender(employeeDto.getGender());
		employeeEntity.setPassword(employeeDto.getPassword());
		employeeEntity.setEmail(employeeDto.getEmail());
		employeeEntity.setPhone(employeeDto.getPhone());
		employeeEntity.setDop(employeeDto.getDop());
		EmployeeEntity entity = employeeRepository.save(employeeEntity);
		if(entity!=null)
			return true;
		else
			return false;
	}

	public boolean deleteEmployee(String empNo) {
		return employeeRepository.deleteEmployeeByEmpNo(empNo);
	}

}