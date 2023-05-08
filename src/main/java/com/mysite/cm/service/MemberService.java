package com.mysite.cm.service;

import com.mysite.cm.entity.member.Member;
import com.mysite.cm.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Optional<Member> findOne(String Email) {
        return repository.findByEmail(Email);
    }
}