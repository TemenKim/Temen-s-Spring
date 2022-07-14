package com.koreait.core.member.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.core.member.dto.Member;

public interface MemberRepository {
	//회원 저장
	Member save(Member member);
	
	// 회원 전체 찾기
	List<Member> findAll();

}
