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
    CHECK_USER_ID(false, 2010, "Body와 URI의 유저 아이디 값이 일치하는지 확인해주세요."),
    CHECK_KEYWORD(false, 2020, "키워드 아이디 값이나 키워드 이름을 확인해주세요."),

    /**
     * 500: server 오류
     */
    SERVER_ERROR(false, 500, "서버 연결에 실패하였습니다."),
    EXCEPTION_ERROR(false, 5000, "Exception이 발생했습니다."),

    /**
     *  3000: Response 오류
     */
    INVALID_USER_ID(false, 3000, "사용자를 찾을 수 없습니다."),
    INVALID_EMAIL(false, 3001, "존재하지 않는 이메일입니다."),
    EXIST_EMAIL(false, 3002, "이미 존재하는 이메일입니다."),
    INVALID_TOKEN(false, 3003, "잘못된 토큰 값입니다."),
    EXPIRED_TOKEN(false, 3004, "만료된 토큰 값입니다."),

    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    MODIFY_FAIL_BUDGET(false, 4001, "예산 금액 변경에 실패하였습니다"),
    RESET_FAIL(false, 4002, "데이터 삭제에 실패했습니다."),
    CREATE_FAIL_CATEGORY(false, 4003, "카테고리 추가에 실패하였습니다"),
    MODIFY_FAIL_CATEGORY(false, 4004, "카테고리 변경에 실패하였습니다"),
    MODIFY_FAIL_DETAIL(false, 4005, "상세 내역 변경에 실패하였습니다"),
    HOME_FAIL_ERROR(false, 4000, "홈 조회에 실패했습니다."),
    CATEGORY_DETAIL_FAIL_ERROR(false, 4000, "상세 분석 조회에 실패했습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
