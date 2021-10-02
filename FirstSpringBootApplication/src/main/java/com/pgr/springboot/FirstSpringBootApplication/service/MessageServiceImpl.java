package com.pgr.springboot.FirstSpringBootApplication.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

	@Override
	public String message() {
		return "First Service Class Demo in Spring Boot Appliction";
	}
}
