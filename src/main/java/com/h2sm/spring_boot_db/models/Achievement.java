package com.h2sm.spring_boot_db.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Achievement {
    private int id;
    private String achievementName;

    @Override
    public String toString(){
        return "Achievement : " + achievementName + " with id " + id;
    }
}