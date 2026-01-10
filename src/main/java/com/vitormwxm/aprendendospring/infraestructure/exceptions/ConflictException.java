package com.vitormwxm.aprendendospring.infraestructure.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
