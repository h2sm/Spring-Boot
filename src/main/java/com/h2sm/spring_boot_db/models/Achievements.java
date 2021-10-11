package com.h2sm.spring_boot_db.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Achievements {
    private int id;
    private String achievement;
}
