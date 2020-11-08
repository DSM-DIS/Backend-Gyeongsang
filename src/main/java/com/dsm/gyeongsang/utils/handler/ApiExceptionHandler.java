package com.dsm.gyeongsang.utils.handler;

import com.dsm.gyeongsang.domains.form.ApiErrorResponseForm;
import com.dsm.gyeongsang.utils.exception.CodeMismatchException;
import com.dsm.gyeongsang.utils.exception.IdMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CodeMismatchException.class)
    public ResponseEntity<ApiErrorResponseForm> codeMismatchException(CodeMismatchException ex) {
        ApiErrorResponseForm response = new ApiErrorResponseForm("Code Mismatch Exception", "코드와 일치하는 일기장을 찾을 수 없음");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdMismatchException.class)
    public ResponseEntity<ApiErrorResponseForm> idMismatchException(IdMismatchException ex) {
        ApiErrorResponseForm response = new ApiErrorResponseForm("ID Mismatch Exception", "아이디와 일치하는 유저를 찾을 수 없음");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
