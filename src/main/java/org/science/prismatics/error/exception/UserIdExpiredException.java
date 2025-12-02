package org.science.prismatics.error.exception;

import org.science.prismatics.error.BaseException;
import org.science.prismatics.error.ErrorCode;

public class UserIdExpiredException extends BaseException {
    public UserIdExpiredException() {
        super(ErrorCode.USERID_EXPIRED);
    }
}
