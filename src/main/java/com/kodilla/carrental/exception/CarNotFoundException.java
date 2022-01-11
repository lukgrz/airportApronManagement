package com.kodilla.carrental.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(Long id) {
        super("There is no car with ID " + id);
    }
}
