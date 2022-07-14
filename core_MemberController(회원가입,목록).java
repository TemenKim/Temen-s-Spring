package com.koreait.core.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koreait.core.member.dto.Member;
import com.koreait.core.member.dto.MemberForm;
import com.koreait.core.member.service.MemberService;

@Controller
public class MemberController {

	// Controller가 Service를 의존한다라고 표현한다.
	// Service는 여러 Controller에서 가져다 쓸 수 있다.
	//MemberService memberService = new MemberService();
	
	// 스프링 스럽게 작업하기
	//@Autowired MemberService memberService;	// 필드주입
	private final MemberService memberService;
	/*
	 * private : application 로딩 시점에 조립하기 때문에 중간에 바꿀일 없다고 보면 된다.
	 * 			 그래서 중간에 바뀔수 있는 가능성을 아에 닫아놓는다.
	 * final   : 선언된 레퍼런스타입 변수는 반드시 선언과 함께 초기화가 되어야 한다.
	 * 			 setter주입시에는 의존관계 주입을 받을 필드에 final 을 선언할 수가 없다. 
	 * 			 객체가 불변 하도록 할 수 있다는 점으로, 누군가가 Controller 내부에서 Service 객체를
	 * 			 바꿔치기 할 수 없다는 점이다.
	 */
	
	
	/*
	 * MemberController가 생성될 때, 생성자를 호출해준다.
	 * 즉, service까지 생성해서 자동으로 호출해준다.
	 * @Autowired를 선언해주면 MemberController생성하면서 스프링이 memberService와 연결을 해준다.
	 */
	// setter injection
//	@Autowired
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	// 생성자를 통한 주입방법
	// @Autowired : 단일 생성자에 한해 @Autowired는 생략 가능
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping(value = "/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	// 회원 가입
	@PostMapping(value = "/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		
		// 홈 화면으로 돌릴다 -> redirect
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
	
	
	
}















