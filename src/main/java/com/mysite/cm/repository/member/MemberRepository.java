package com.mysite.cm.repository.member;

import com.mysite.cm.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email); 
    Optional<Member> findByNickname(String nickname);

    boolean existsByEmail(String email); 
    boolean existsByNickname(String nickname);
}