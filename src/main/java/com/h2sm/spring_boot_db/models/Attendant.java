package com.h2sm.spring_boot_db.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Attendant {
    private int id;
    private String name;
    private String phoneNumber;

    @Override
    public String toString(){
        return "Attendant [id = " + ", name = " + name + ", phone number = " +phoneNumber + "]";
    }
}
