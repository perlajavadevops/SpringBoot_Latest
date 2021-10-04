package com.pgr.sb.mvc.SBDevToolsDemo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

		@RequestMapping("/")
		public String welcome(Map<String, Object> model) {
			model.put("message", "Wellcome First Spring Boot MVC Example     sdfsaf  sdf  ");
			return "welcome";
		}
		
		@RequestMapping("/message")
		public String testMessage(Map<String, Object> model) {
			model.put("testMsg", "Testing Devtools functionality");
			return "welcome";
		}
}
