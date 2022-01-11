package com.kodilla.carrental.exception;

public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(Long id) {
        super("Invoice with id " + id + " don't exist");
    }
}
