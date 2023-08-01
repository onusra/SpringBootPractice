package com.example.demo.errohandling;

public class ExceptionHandling extends Exception{

    public ExceptionHandling() {
        super();
    }

    public ExceptionHandling(String message) {
        super(message);
    }

    public ExceptionHandling(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionHandling(Throwable cause) {
        super(cause);
    }

    protected ExceptionHandling(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
