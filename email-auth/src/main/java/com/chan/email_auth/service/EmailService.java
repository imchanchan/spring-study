package com.chan.email_auth.service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        try {
            // MimeMessage 생성
            MimeMessage message = mailSender.createMimeMessage();

            // MimeMessageHelper로 메시지 설정
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to); // 수신자
            helper.setSubject(subject); // 제목
            helper.setText(text, true); // 본문 (HTML 가능)

            // 이메일 전송
            mailSender.send(message);
            System.out.println("Email sent to " + to);

        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
            throw new RuntimeException("Email sending failed", e);
        }
    }
}
