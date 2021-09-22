package com.akhilesh.controller;

import com.akhilesh.errorhandling.StudentError;
import com.akhilesh.errorhandling.StudentNotFoundException;
import com.akhilesh.pojo.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    public List<Student> students;

    @PostConstruct //To load data to the list only once
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("Akhilesh","Magdum"));
        students.add(new Student("Purva","Magdum"));
    }

    @RequestMapping("/students-list")
    public List<Student> showStudentsList(){
        return students;
    }

    @GetMapping("student/{studentId}")
    public Student showStudentById(@PathVariable int studentId){
        if((studentId>=students.size()) || studentId<0) {
            throw new StudentNotFoundException("Student with id "+studentId+" does not exist");
        }
        return students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentError> handleException(StudentNotFoundException exception){
        StudentError error = new StudentError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

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
