package com.koreait.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.thymeleaf.data.User;


@Controller
@RequestMapping("/template")
public class TemplateController {

	@GetMapping("/fragment")
	public String template(Model model) {
		
		return "template/fragment/fragmentMain";
	}
	
	@GetMapping("/layout")
	public String layout(Model model) {
		
		return "template/layout/layoutMain";
	}
	


	
}
