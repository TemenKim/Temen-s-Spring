package com.koreait.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @Controller : Controller 클라스에는 @Controller이 필요
 * 				 Controller에서 해당 mapping url을 찾는다
 * 
 */

@Controller
public class HelloController {

		
		// @GetMapping : get방식의 요청 mapping
		@GetMapping("hello")
		// void가 뭐엿더라
		// jsp에서는 어케햇길래?
		public String hello(Model model) {
			System.out.println("hello");
			model.addAttribute("data","new springboot");
			return "hello";
		}
		
		/*
		 * 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰리졸버(ViewResolver)가
		 * 화면을 찾아서 처리한다.
		 * -스프링부트기본 viewName을 매핑
		 * -resources:templates/ + {viewName} + .html
		 * 
		 */
		
		// @RequestParam : 파라미터값 받아오는데, 필수
		// 	-required	 : 파라미터 값 필수 여부, true - 필수(default), false - 필수아님
		//  -defaultValue	: 파라미터 값이 없을 경우 기본으로 들어갈 값
		
//		http://localhost:9091/hello-mvc?name=temen
		@GetMapping("hello-mvc")
		public String helloMvc(@RequestParam(value = "name", required = false, defaultValue = "required test") String name, Model model) {
			
			model.addAttribute("name", name);
			return "hello-template";
		}
		
		
		
		
		
		
		
	
}






















