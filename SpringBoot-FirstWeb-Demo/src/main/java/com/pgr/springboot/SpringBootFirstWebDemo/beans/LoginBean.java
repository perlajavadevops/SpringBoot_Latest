package com.pgr.springboot.SpringBootFirstWebDemo.beans;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class LoginBean {

	private String userName;
	private String password;

}
