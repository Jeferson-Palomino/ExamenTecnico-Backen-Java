package com.example.cajero.exception;

public class BadRequestException extends RuntimeException {

    private static final String DESCRIPTION = "Bad Request Exception";

    public BadRequestException(String detail) {
        super(String.format("%s - %s", DESCRIPTION, detail));
    }
}
