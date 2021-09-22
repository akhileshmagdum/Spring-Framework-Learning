package com.akhilesh.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandlerGlobal {

    //Generic exception handler
    @ExceptionHandler
    public ResponseEntity<StudentError> handleException(Exception exception){
        StudentError error = new StudentError();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Enter valid request");
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
