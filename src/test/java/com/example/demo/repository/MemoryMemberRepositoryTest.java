package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;

class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	//test 위주로 test 먼저 작성하고 개발 구현하는 개발을 TDD
	@AfterEach
	public void afterEach() {//Test 순서 상관 없이 실행됨 Test 끝날 때마다 실행
		repository.clearstore();
	}
	@Test
	public void save() {
		Member member = new Member();
		repository.save(member);
		Member result = repository.findById(member.getId()).get();//Optional에서 값 꺼내기
		org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
		
	}
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result = repository.findByName("spring1").get();
		org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);
		
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> list=repository.findAll();
		org.assertj.core.api.Assertions.assertThat(list.size()).isEqualTo(2);
	}
}
