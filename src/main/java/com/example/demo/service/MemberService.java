package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository;
	public MemberService(MemoryMemberRepository memoryMemberRepository) {
		this.memberRepository = memoryMemberRepository;
	}
	//회원가입
	public Long join(Member member) {
		//같은 이름 중복 X
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
		
	}
	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m->{
				throw new IllegalStateException("already exist.");
			});
	}
	
	//전체회원조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	//회원한명조회
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
}
