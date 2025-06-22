package com.lucas.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CpfException.class)
    public ResponseEntity<String> handleCpfJaCadastrado(CpfException ex) {
        return ResponseEntity.status(422).body(ex.getMessage());
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<String> handleEmailJaCadastrado(EmailException ex) {
        return ResponseEntity.status(422).body(ex.getMessage());
    }
}
