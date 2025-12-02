package org.science.prismatics.error.exception;

import org.science.prismatics.error.BaseException;
import org.science.prismatics.error.ErrorCode;

public class BadRequestException extends BaseException {
    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST);
    }
}
