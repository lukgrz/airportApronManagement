package com.kodilla.carrental.exception;

public class EquipmentNotFoundException extends RuntimeException{

    public EquipmentNotFoundException(Long id) {
        super("Equipment with id " + id + " don't exist");
    }
}
