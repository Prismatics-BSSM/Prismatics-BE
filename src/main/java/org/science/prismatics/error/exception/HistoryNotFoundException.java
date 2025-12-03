package org.science.prismatics.error.exception;

import org.science.prismatics.error.BaseException;
import org.science.prismatics.error.ErrorCode;

public class HistoryNotFoundException extends BaseException {
    public HistoryNotFoundException() {
        super(ErrorCode.HISTORY_NOT_FOUND);
    }
}
