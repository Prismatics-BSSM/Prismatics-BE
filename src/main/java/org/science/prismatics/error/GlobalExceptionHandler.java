package org.science.prismatics.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
        ErrorCode code = e.getErrorCode();
        ErrorResponse response = new ErrorResponse(code.getMessage());
        return ResponseEntity.status(code.getStatus()).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse response = new ErrorResponse("서버 내부 오류가 발생했습니다.");
        return ResponseEntity.status(500).body(response);
    }
}