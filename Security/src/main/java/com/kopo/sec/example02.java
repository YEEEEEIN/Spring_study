package com.kopo.sec;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class example02 {

	@GetMapping("/exam02")
	public String requestMethod(Model model) {
		return "webpage_02";
	}
	
	@GetMapping("/manager/tag")
	public String requestMethod3(Model model) {
		model.addAttribute("data", "/webpage/managerPage.jsp");
		return "webpage_02";
	}

}
