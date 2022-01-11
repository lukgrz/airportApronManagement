package com.kodilla.carrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvoiceNotFoundAdvice {

    @ExceptionHandler(InvoiceNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String InvoiceNotFoundHandler(InvoiceNotFoundException ex) {
        return ex.getMessage();
    }
}
