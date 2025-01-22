package com.chan.email_auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberEmailVerifyResponseDto {
    private boolean isVerified; // 인증 성공 여부
    private String message;     // 인증 결과 메시지
}
