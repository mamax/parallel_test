package com.epam.framework.exceptions;

public class ReportCollectorException extends RuntimeException {
    public ReportCollectorException() {
        super();
    }

    public ReportCollectorException(String message) {
        super(message);
    }

    public ReportCollectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportCollectorException(Throwable cause) {
        super(cause);
    }

    protected ReportCollectorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
