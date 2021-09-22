package com.akhilesh.controller;

import com.akhilesh.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return students.get(studentIds);
    }
}
