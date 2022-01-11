package com.kodilla.carrental.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super("Client with ID " + id + " don't exist");
    }
}
