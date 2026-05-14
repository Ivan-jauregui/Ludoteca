package com.ludoteca.exceptions.response;

public class InvalidStockException extends RuntimeException {
    public InvalidStockException(String message) {
        super(message);
    }
}
