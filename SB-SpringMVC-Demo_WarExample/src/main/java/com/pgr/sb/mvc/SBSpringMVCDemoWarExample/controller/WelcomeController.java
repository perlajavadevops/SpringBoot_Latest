package com.pgr.sb.mvc.SBSpringMVCDemoWarExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	//@GetMapping(value = "/")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(Model model) {
		
		model.addAttribute("message", "Welcome First SB MVC Example");
		return "index";
		
	}
}
