package org.science.prismatics.error.exception;

import org.science.prismatics.error.BaseException;
import org.science.prismatics.error.ErrorCode;

public class ElementNotFoundException extends BaseException {
    public ElementNotFoundException() {
        super(ErrorCode.ELEMENT_NOT_FOUND);
    }
}
