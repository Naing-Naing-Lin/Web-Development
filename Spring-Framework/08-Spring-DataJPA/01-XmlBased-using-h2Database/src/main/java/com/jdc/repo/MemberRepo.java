package com.jdc.repo;

import org.springframework.data.repository.ListCrudRepository;

import com.jdc.entity.Member;

public interface MemberRepo extends ListCrudRepository<Member, Integer>{

}
