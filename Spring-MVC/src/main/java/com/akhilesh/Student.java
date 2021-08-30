package com.akhilesh;

import java.util.HashMap;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String state;
    private String prgLang;
    private HashMap<String,String> stateList;
    public HashMap<String,String> prgLangList;

    public Student(){
        stateList = new HashMap<>();
        stateList.put("Maharashtra","MH");
        stateList.put("Jammu & Kashmir","JK");
        stateList.put("West Bengal","WB");
        stateList.put("Karnataka","KA");
        stateList.put("Gujarat","GJ");
        stateList.put("Goa","GA");

        prgLangList = new HashMap<>();
        prgLangList.put("Java","Java");
    }

    public HashMap<String, String> getPrgLangList() {
        return prgLangList;
    }

    public void setPrgLangList(HashMap<String, String> prgLangList) {
        this.prgLangList = prgLangList;
    }

    public String getPrgLang() {
        return prgLang;
    }

    public void setPrgLang(String prgLang) {
        this.prgLang = prgLang;
    }

    public HashMap<String, String> getStateList() {
        return stateList;
    }

    public void setStateList(HashMap<String, String> stateList) {
        this.stateList = stateList;
    }

    public String getState() {
        return state;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setState(String state) {
        this.state = state;
    }

}
