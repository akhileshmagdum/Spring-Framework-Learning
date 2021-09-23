package com.akhilesh.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerError> handleException(Exception exception){
        CustomerError error = new CustomerError();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Enter a valid number");

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
