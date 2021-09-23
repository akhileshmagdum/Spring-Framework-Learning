package com.akhilesh.errorhandling;

public class CustomerException extends RuntimeException{

    public CustomerException(String message) {
        super(message);
    }
}
