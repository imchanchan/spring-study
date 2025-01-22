package com.chan.email_auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberEmailVerifyRequestDto {
    private String email;             // 이메일 주소
    private String verificationCode;  // 인증 코드
}
