package com.dsm.gyeongsang.utils.exception;

public class IdMismatchException extends RuntimeException {
    public IdMismatchException() {
        super("아이디에 맞는 유저를 찾을 수 없습니다.");
    }
}
