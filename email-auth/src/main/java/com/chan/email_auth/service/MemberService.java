package com.chan.email_auth.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MemberService {

    private final EmailService emailService;

    // 이메일과 인증 코드를 저장하는 임시 저장소 (실제 서비스에서는 Redis, DB 등을 사용)
    private final Map<String, String> verificationCodes = new HashMap<>();

    public MemberService(EmailService emailService) {
        this.emailService = emailService;
    }

    // 이메일로 인증 코드 전송
    public void sendCodeToEmail(String email) {
        // 인증 코드 생성
        String verificationCode = generateVerificationCode();

        // 인증 코드 저장
        verificationCodes.put(email, verificationCode);

        // 이메일 전송
        String subject = "이메일 인증 코드";
        String message = "인증 코드: " + verificationCode;
        emailService.sendEmail(email, subject, message);
    }

    // 이메일 및 인증 코드 검증
    public boolean verifyCode(String email, String verificationCode) {
        // 저장된 인증 코드 확인
        String storedCode = verificationCodes.get(email);

        // 인증 코드가 일치하는지 확인
        if (storedCode != null && storedCode.equals(verificationCode)) {
            // 인증 성공 시 저장된 코드 제거
            verificationCodes.remove(email);
            return true;
        }

        return false;
    }

    // 인증 코드 생성 (6자리 랜덤 숫자)
    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // 100000 ~ 999999
        return String.valueOf(code);
    }
}
