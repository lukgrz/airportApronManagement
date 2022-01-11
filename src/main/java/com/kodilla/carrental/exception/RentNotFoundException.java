package com.kodilla.carrental.exception;

public class RentNotFoundException extends RuntimeException {

    public RentNotFoundException (Long id) {
        super ("Rent with id " + id + " don't exist");
    }
}
