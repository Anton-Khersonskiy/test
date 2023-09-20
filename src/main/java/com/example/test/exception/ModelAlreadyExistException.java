package com.example.test.exception;

public class ModelAlreadyExistException extends Exception{
    public ModelAlreadyExistException(String message) {
        super(message);
    }
}
