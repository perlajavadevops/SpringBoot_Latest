package com.pgr.sb.mvc.SBRestDemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgr.sb.mvc.SBRestDemo.dto.MessageDto;

@RestController
public class EmployeeResource {

	@GetMapping(value = "/message"/*
									 * , consumes = MediaType.APPLICATION_JSON_VALUE, produces =
									 * MediaType.APPLICATION_JSON_VALUE
									 */)
	public @ResponseBody String getMessage() {
		return "Hello First SB Rest API Example";
	}
	
	/*
	 * {
	 *    "message":"Hello First SB Rest API Example"
	 * }
	 */
	@GetMapping(value = "/jsonMessage")
	public @ResponseBody MessageDto getJsonMessage() {
		MessageDto dto = new MessageDto();
		dto.setMessage("Hello First SB Rest API Example with JSON Data");
		return dto;
	}
}
