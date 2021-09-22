package com.akhilesh.controller;

import com.akhilesh.errorhandling.StudentNotFoundException;
import com.akhilesh.pojo.Student;
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

}
