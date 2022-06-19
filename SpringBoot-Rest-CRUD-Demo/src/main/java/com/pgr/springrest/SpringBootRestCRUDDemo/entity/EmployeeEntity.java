package com.pgr.springrest.SpringBootRestCRUDDemo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity
@Table(name = "employee_details_b3")
public class EmployeeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5750609611126568015L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
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