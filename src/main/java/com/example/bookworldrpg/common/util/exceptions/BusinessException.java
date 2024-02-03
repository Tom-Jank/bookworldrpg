package com.example.bookworldrpg.common.util.exceptions;

public class BusinessException extends RuntimeException {

    public final transient BusinessExceptionCode error;

    public BusinessException(BusinessExceptionCode error) {
        super(error.getCode() + " " + error.getMessage(), null, true, false);
        this.error = error;
    }
}
