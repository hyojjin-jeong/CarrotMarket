package com.mysite.cm.dto;

import com.mysite.cm.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String username;
    private String nickname;

    public static MemberDto empty() {
        return new MemberDto(null, "", "", "");
    }
}