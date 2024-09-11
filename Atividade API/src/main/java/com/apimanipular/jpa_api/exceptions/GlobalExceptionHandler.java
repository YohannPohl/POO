package com.apimanipular.jpa_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(TaskAlreadyFinalizedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleTaskAlreadyFinalizedException(TaskAlreadyFinalizedException ex) {
        return ex.getMessage();
    }
}