package org.science.prismatics.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    ELEMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "Element Not Found"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
    USERID_INVALID(HttpStatus.UNAUTHORIZED, "UserId Invalid"),
    HISTORY_NOT_FOUND(HttpStatus.NOT_FOUND, "History Not Found"),
    USER_INCORRECT(HttpStatus.FORBIDDEN, "User Incorrect"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurred"),;

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}