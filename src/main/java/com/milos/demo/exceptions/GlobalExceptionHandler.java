package com.milos.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({AccountNotFoundException.class})
    public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException accountNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(accountNotFoundException.getMessage());
    }

}
