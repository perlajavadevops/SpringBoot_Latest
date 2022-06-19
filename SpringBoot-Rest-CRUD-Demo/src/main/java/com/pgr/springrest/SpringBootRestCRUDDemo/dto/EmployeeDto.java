package com.pgr.springrest.SpringBootRestCRUDDemo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5733194512264840345L;
	
	private Integer id;
	private String empNo;
	private String firstName;
	private String lastName;
	private String deptName;
	private String designation;
	private Double salary;
	private String branch;
	private String country;
	private String gender;
	private String password;
	private String email;
	private String phone;
	private String dob;
	
	
}
