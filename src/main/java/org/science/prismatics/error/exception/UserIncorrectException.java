package org.science.prismatics.error.exception;

import org.science.prismatics.error.BaseException;
import org.science.prismatics.error.ErrorCode;

public class UserIncorrectException extends BaseException {
    public UserIncorrectException() {
        super(ErrorCode.USER_INCORRECT);
    }
}
