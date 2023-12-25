package com.anant.SpringbootExceptionHandling.exception;

public class UserNotFoundException  extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}