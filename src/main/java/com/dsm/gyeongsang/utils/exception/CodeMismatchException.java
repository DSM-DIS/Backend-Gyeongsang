package com.dsm.gyeongsang.utils.exception;

public class CodeMismatchException extends RuntimeException {
    public CodeMismatchException() {
        super("일치하는 코드가 존재하지 않습니다.");
    }
}
