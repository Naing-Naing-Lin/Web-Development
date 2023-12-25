package com.jdc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{

}
