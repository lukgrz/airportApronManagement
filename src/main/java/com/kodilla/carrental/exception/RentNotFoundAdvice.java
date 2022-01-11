package com.kodilla.carrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(RentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String RentNotFoundHandler (RentNotFoundException ex) {
        return ex.getMessage();
    }
}
