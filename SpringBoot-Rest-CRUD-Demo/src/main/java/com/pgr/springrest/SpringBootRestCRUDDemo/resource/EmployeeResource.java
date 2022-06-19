package com.pgr.springrest.SpringBootRestCRUDDemo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgr.springrest.SpringBootRestCRUDDemo.dto.EmployeeDto;
import com.pgr.springrest.SpringBootRestCRUDDemo.dto.MessageDto;
import com.pgr.springrest.SpringBootRestCRUDDemo.exception.InternalServerException;
import com.pgr.springrest.SpringBootRestCRUDDemo.service.EmployeeService;

@RestController
public class EmployeeResource {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/employeeList")
	public @ResponseBody List<EmployeeDto> listOfEmployee() {

		List<EmployeeDto> employeeList = employeeService.getListOfEmployee();
		return employeeList;
	}

	@PostMapping(value = "/addEmployee")
	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<MessageDto> addEmployee(@RequestBody EmployeeDto employee) throws Exception {
		boolean flag = employeeService.addEmployee(employee);
		System.out.println("Flag: " + flag);
		MessageDto messageDto = new MessageDto();

		if (flag) {
			messageDto.setMessage(
					"Employee " + employee.getFirstName() + ", " + employee.getLastName() + " added successfully...");
			ResponseEntity<MessageDto> response = new ResponseEntity<>(messageDto, HttpStatus.OK);
			return response;
		} else {
			messageDto.setMessage("Error occured while registering employee, please try again...");
			ResponseEntity<MessageDto> response = new ResponseEntity<>(messageDto, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}

	}

	@ResponseBody
	// @RequestMapping(value = "/updateEmployee/{empNo}", method =
	// RequestMethod.PUT)
	@PutMapping(value = "/updateEmployee/{empNo}")
	public MessageDto updateEmployee(@RequestBody EmployeeDto employee, @PathVariable("empNo") String empNo) {
		System.out.println(employee.getFirstName());
		MessageDto messageDto = new MessageDto();
		String msg = "Error occured while updating employee: " + employee.getFirstName() + ", " + employee.getLastName()
				+ ",  please try again";
		try {
			if (employee != null) {
				boolean flag = employeeService.updateEmployee(employee, empNo);
				if (flag) {
					msg = "Employee ID: " + employee.getEmpNo() + " details updated successfully...";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		messageDto.setMessage(msg);
		return messageDto;
	}

	@ResponseBody
	// @RequestMapping(value = "/deleteEmployee/{empNo}", method =
	// RequestMethod.DELETE)
	@DeleteMapping(value = "/deleteEmployee/{empNo}")
	public MessageDto deleteEmployee(@PathVariable String empNo) {
		System.out.println("inside delete");
		String msg = "Error occured while deleting employee: " + empNo;
		MessageDto messageDto = new MessageDto();

		try {
			if (empNo != null) {
				boolean flag = employeeService.deleteEmployee(empNo);
				if (flag) {
					msg = "Employee ID: " + empNo + " deleted successfully...";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		messageDto.setMessage(msg);
		return messageDto;
	}

	@ResponseBody
	// @RequestMapping(value = "/deleteMultipleEmployeesByEmpNo", method =
	// RequestMethod.DELETE)
	@DeleteMapping(value = "/deleteMultipleEmployeesByEmpNo")
	public MessageDto deleteMultipleEmployeesByEmpNo(@RequestBody ArrayList<String> empNo) {
		System.out.println("inside delete");
		String msg = "Error occured while deleting employee: " + empNo;
		MessageDto messageDto = new MessageDto();

		try {
			if (empNo != null) {
				boolean flag = employeeService.deleteMultipleEmployeesByEmpNo(empNo);
				if (flag) {
					msg = "Employee ID: " + empNo + " deleted successfully...";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		messageDto.setMessage(msg);
		return messageDto;
	}

	@ResponseBody
	// @RequestMapping(value = "/employeeDetails/{empNo}", method =
	// RequestMethod.GET)
	@GetMapping(value = "/employeeDetails/{empNo}")
	public EmployeeDto getEmployeeDetailsById(@PathVariable String empNo) {
		System.out.println("inside delete");
		EmployeeDto employeeDto = new EmployeeDto();

		try {
			if (empNo != null) {
				employeeDto = employeeService.getEmployeeDetailsById(empNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeDto;
	}

	@ResponseBody
	// @RequestMapping(value = "/updateEmployeeByPatch/{empNo}", method =
	// RequestMethod.PATCH)
	@PatchMapping(value = "/updateEmployeeByPatch/{empNo}")
	public MessageDto updateEmployeeByPatch(@RequestBody EmployeeDto employee, @PathVariable("empNo") String empNo) {
		System.out.println(employee.getFirstName());
		MessageDto messageDto = new MessageDto();
		String msg = "Error occured while updating employee: " + employee.getFirstName() + ", " + employee.getLastName()
				+ ",  please try again";
		try {
			if (employee != null) {
				boolean flag = employeeService.updateMandatoryEmployeeData(employee, empNo);
				if (flag) {
					msg = "Employee ID: " + empNo + " details updated successfully...";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		messageDto.setMessage(msg);
		return messageDto;
	}

}
