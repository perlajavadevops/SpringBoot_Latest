package com.pgr.springrest.SpringBootRestCRUDDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgr.springrest.SpringBootRestCRUDDemo.dto.EmployeeDto;
import com.pgr.springrest.SpringBootRestCRUDDemo.entity.EmployeeEntity;
import com.pgr.springrest.SpringBootRestCRUDDemo.exception.InternalServerException;
import com.pgr.springrest.SpringBootRestCRUDDemo.repository.EmployeeRepository;

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
			employeeDto.setDob(entity.getDob());

			employeesList.add(employeeDto);

		}
		return employeesList;
	}

	public boolean addEmployee(EmployeeDto employeeDto) throws Exception {

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
		employeeEntity.setDob(employeeDto.getDob());

		EmployeeEntity entity = null;
		EmployeeEntity entity2 = employeeRepository.getEmployeeDetailsById(employeeDto.getEmpNo());
		if (entity2 != null && entity2.getEmpNo().equals(employeeDto.getEmpNo())) {
			throw new InternalServerException("EMPLOYEE_SAVE_ISSUE",
					"Employee id is present... please provide alternative empno for creating new employee....");
		} else {
			entity = employeeRepository.save(employeeEntity);
		}

		if (entity != null)
			return true;
		else
			return false;
	}

	@Transactional
	public boolean updateEmployee(EmployeeDto employeeDto, String empNo) {

		EmployeeEntity employeeEntity = employeeRepository.getEmployeeDetailsById(empNo);

		// employeeEntity.setId(employeeDto.getId());
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
		employeeEntity.setDob(employeeDto.getDob());
		// boolean flag = employeeRepository.updateEmployee(employeeDto.getEmpNo(),
		// employeeDto.getDesignation(), employeeDto.getPhone());

		EmployeeEntity entity = employeeRepository.save(employeeEntity);
		if (entity != null)
			return true;
		else
			return false;
	}

	public boolean deleteEmployee(String empNo) {

		int i = employeeRepository.deleteEmployeeByEmpNo(empNo);
		if (i == 1)
			return true;
		else
			return false;
	}

	public boolean deleteMultipleEmployeesByEmpNo(ArrayList<String> empNo) {

		int i = employeeRepository.deleteMultipleEmployeesByEmpNo(empNo);
		if (i == 1)
			return true;
		else
			return false;

		// employeeRepository.deleteInBatch(empNo);
	}

	@Override
	public EmployeeDto getEmployeeDetailsById(String empNo) {
		EmployeeEntity entity = employeeRepository.getEmployeeDetailsById(empNo);

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
		employeeDto.setDob(entity.getDob());

		return employeeDto;
	}

	@Transactional
	@Override
	public boolean updateMandatoryEmployeeData(EmployeeDto employeeDto, String empNo) {
		EmployeeEntity employeeEntity = employeeRepository.getEmployeeDetailsById(empNo);

		employeeEntity.setSalary(employeeDto.getSalary());
		employeeEntity.setPhone(employeeDto.getPhone());
		employeeEntity.setDob(employeeDto.getDob());

		EmployeeEntity entity = employeeRepository.save(employeeEntity);
		if (entity != null)
			return true;
		else
			return false;
	}

}