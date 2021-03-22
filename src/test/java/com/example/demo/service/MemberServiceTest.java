package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;

class MemberServiceTest {
	MemberService memberService;
	MemoryMemberRepository memberRepository;
	@BeforeEach
	void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	@AfterEach
	public void afterEach() {//Test 순서 상관 없이 실행됨 Test 끝날 때마다 실행
		memberRepository.clearstore();
	}
	@Test
	void testJoin() {
		//given
		Member member = new Member();
		member.setName("spring");
		//when
		Long saveId = memberService.join(member);
		//then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	void testFindMembers() {

	}

	@Test
	void testFindOne() {

	}

}
