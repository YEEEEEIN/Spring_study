package com.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "login"; // login.jsp로
	}
	
	@GetMapping("/loginfailed")
	public String loginError(Model model) {
		model.addAttribute("error", "true"); // 에러 발생
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "login"; // login.jsp로
	}

}
