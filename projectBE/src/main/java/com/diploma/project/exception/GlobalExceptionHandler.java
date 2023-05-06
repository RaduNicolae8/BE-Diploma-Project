package com.diploma.project.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        log.error("Thrown error with message {}", ex.getErrorMessage(), ex);
        CustomExceptionObject customExceptionObject = new CustomExceptionObject(ex.getErrorMessage(), ex.getErrorStatus(), ex.getErrorCode());
        return new ResponseEntity<>(customExceptionObject, ex.getErrorStatus() != null ? ex.getErrorStatus() : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        CustomExceptionObject customExceptionObject = new CustomExceptionObject(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(customExceptionObject, customExceptionObject.getErrorStatus());
    }
}

