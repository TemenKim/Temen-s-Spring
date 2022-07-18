package com.koreait.thymeleaf.basic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.thymeleaf.data.User;

@Controller
@RequestMapping("/basic")
public class BasicController {

	private void addUsers(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User("userA", 10));
		list.add(new User("userB", 20));
		list.add(new User("userC", 30));
		model.addAttribute("users", list);
	}


	@GetMapping("/condition")
	public String condition(Model model) {
		addUsers(model);
		return "basic/condition";
	}


}





















