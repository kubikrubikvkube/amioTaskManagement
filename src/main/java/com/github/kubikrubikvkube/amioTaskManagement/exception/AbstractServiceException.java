package com.github.kubikrubikvkube.amioTaskManagement.exception;

import lombok.Getter;

@Getter
public abstract class AbstractServiceException extends RuntimeException {

    protected final String errorDetails;

    protected AbstractServiceException(String errorDetails) {
        this.errorDetails = errorDetails;
    }

}
