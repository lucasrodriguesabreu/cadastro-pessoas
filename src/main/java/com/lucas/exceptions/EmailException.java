package com.lucas.exceptions;

public class EmailException extends RuntimeException {
    public EmailException(String message) {
        super(message);
    }
}
