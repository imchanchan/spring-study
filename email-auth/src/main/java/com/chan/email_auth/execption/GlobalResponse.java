package com.chan.email_auth.execption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalResponse<T> {
    private String status; // 상태 코드 (예: "200", "400")
    private String message; // 상태 메시지 (예: "요청 성공", "요청 실패")
    private T data;         // 응답 데이터

    // 성공 응답 생성
    public static <T> GlobalResponse<T> of(String status, String message, T data) {
        GlobalResponse<T> response = new GlobalResponse<>();
        response.setStatus(status);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    // 성공 응답 생성 (데이터 없이)
    public static <T> GlobalResponse<T> of(String status, String message) {
        return of(status, message, null);
    }
}
