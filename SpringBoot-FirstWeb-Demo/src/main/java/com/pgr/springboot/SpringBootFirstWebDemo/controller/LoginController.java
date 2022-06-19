package com.pgr.springboot.SpringBootFirstWebDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pgr.springboot.SpringBootFirstWebDemo.beans.LoginBean;

@Controller
public class LoginController {

	@GetMapping("/")
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView("login");
		model.addObject("msg", "Please Enter Your Login Details");
		return model;

	}

	@PostMapping(value = "/login") // / action
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {

		try {
			if (loginBean != null) {
				if (loginBean.getUserName().equals("perlareddy")) {
					model.addAttribute("msg", loginBean.getUserName());
					return "success";
				} else {
					model.addAttribute("error", "Invalid Details");
					return "login";
				}
			} else {
				model.addAttribute("error", "Please enter Details");
				return "login";
			}
		} catch (Exception e) {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}

}
