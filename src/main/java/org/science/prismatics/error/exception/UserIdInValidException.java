package org.science.prismatics.error.exception;

import org.science.prismatics.error.BaseException;
import org.science.prismatics.error.ErrorCode;

public class UserIdInValidException extends BaseException {
    public UserIdInValidException() {
        super(ErrorCode.USERID_INVALID);
    }
}
