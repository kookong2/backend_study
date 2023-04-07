package org.koreait.commons.errors;

import jakarta.servlet.http.HttpServletResponse;

public class CommonException extends RuntimeException {
    
    private int status; // 응답 상태코드

    public CommonException(String message) {
        this(message, HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 응답 메세지만 입력하면 응답 상태 코드는 500으로 고정
    }

    public CommonException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
