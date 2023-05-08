package com.mysite.cm.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.mysite.cm.entity.member.Member;

import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class MemberJoinDto {


    @NotEmpty(message = "이메일 입력은 필수 입니다.")
    private String email;
    @NotEmpty(message = "비밀번호 입력은 필수 입니다.")
    private String password;
    @NotEmpty(message = "이름 입력은 필수 입니다.")
    private String name;
    @NotEmpty(message = "닉네임 입력은 필수 입니다.")
    private String nickname;

    @Builder
    public MemberJoinDto(String email, String password, String name,String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    /*
    * 회원 엔티티로 변환
    * */
    public Member toMemberEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .username(name)
                .build();
    }

}
