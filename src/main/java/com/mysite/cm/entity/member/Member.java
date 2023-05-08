package com.mysite.cm.entity.member;

import com.mysite.cm.entity.common.EntityDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Builder;

import jakarta.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends EntityDate { 

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true) 
    private String email;

    private String password; 

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, unique = true, length = 20) 
    private String nickname;
    
    @Builder
    public Member(String email, String password, String username, String nickname) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public static Member createMember(String email, String pw, PasswordEncoder passwordEncoder) {
        return new Member(email, passwordEncoder.encode(pw), "USERNAME","NICKNAME");
    }

}