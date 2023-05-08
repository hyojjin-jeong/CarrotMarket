package com.mysite.cm.config.security;

import com.mysite.cm.entity.member.Member;
import com.mysite.cm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {
    private final MemberService memberService;

    @Autowired
    public MyUserDetailsService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        Optional<Member> findOne = memberService.findOne(Email);
        Member member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다."));

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
