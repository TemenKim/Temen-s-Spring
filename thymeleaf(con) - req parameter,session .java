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


	@GetMapping("basic-objects")
	public String basicObjects(HttpSession session) {
		session.setAttribute("sessionData", "UserID");
		return "basic/basic-objects";
	}



}





















