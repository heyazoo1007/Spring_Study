package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);//null을 Optional로 감싸서 반환?
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
