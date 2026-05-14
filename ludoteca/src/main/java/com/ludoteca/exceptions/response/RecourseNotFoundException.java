package com.ludoteca.exceptions.response;

public class RecourseNotFoundException extends RuntimeException {
    public RecourseNotFoundException(String message) {
        super(message);
    }
}
