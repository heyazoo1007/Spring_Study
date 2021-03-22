package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;

@Configuration
public class SpringConfig {

	//@Component 없이 수동 설정 @Controller는 필요
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	@Bean
	public MemoryMemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
