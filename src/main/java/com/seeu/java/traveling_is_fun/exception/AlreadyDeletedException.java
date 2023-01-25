package com.seeu.java.traveling_is_fun.exception;

public class AlreadyDeletedException extends RuntimeException{
    public AlreadyDeletedException(String message) {
        super(message);
    }
}
