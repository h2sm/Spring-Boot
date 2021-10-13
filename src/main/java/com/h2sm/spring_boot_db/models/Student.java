package com.h2sm.spring_boot_db.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private int age;
    private String fullName;
    private String email;
    private String groupName;
    private boolean isChef;
    @Override
    public String toString(){
        return "Student "+ id + " "+ fullName + ", age " + age + ", email " + email + ", groupname " + groupName + ",ischef " + isChef;
    }
}
