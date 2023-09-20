package com.example.test.exception;

public class BrandAlreadyExistException extends Exception{
    public BrandAlreadyExistException(String message) {
        super(message);
    }
}
