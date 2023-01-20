package com.flow.flow.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 200: 요청 성공
     */
    SUCCESS(true, 200, "요청에 성공하였습니다."),

    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    MODIFY_FAIL_BUDGET(false, 4001, "예산 금액 변경에 실패하였습니다");

    private final boolean isSuccess;
    private final int code;
    private final String message;
    private BaseResponseStatus(boolean isSuccess, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
