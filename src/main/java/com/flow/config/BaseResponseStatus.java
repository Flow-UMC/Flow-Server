package com.flow.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 200: 요청 성공
     */
    SUCCESS(true, 200, "요청에 성공하였습니다."),

    /**
     * 2000: request 오류
     */
    CHECK_USER_ID(false, 2010, "유저 아이디 값을 확인해주세요."),
    CHECK_KEYWORD(false, 2020, "키워드 아이디 값이나 키워드 이름을 확인해주세요."),

    /**
     * 500: server 오류
     */
    SERVER_ERROR(false, 500, "서버 연결에 실패하였습니다."),

    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    MODIFY_FAIL_BUDGET(false, 4001, "예산 금액 변경에 실패하였습니다"),
    RESET_FAIL(false, 4002, "데이터 삭제에 실패했습니다."),
    CREATE_FAIL_CATEGORY(false, 4003, "카테고리 추가에 실패하였습니다"),
    MODIFY_FAIL_CATEGORY(false, 4004, "카테고리 변경에 실패하였습니다"),
    MODIFY_FAIL_DETAIL(false, 4005, "상세 내역 변경에 실패하였습니다"),
    HOME_FAIL_ERROR(false, 4000, "지난 달 데이터가 존재하지 않습니다.");
    
    

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
