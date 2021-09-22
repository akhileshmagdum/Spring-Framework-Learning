package com.akhilesh.jsondatabinding;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Student student = mapper.readValue(new File("data/student.json"),Student.class);

        System.out.println(student.getId()+"\n"+student.getFirstName()+" "+student.getLastName()
                +"\n"+student.getBacklog()+" "+student.isResult());
    }
}
