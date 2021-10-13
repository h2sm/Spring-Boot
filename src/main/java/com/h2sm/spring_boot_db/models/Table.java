package com.h2sm.spring_boot_db.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Table {
    private int tableNumber;
    private String tableName;
    @Override
    public String toString(){
        return "Table " +"'"+ tableName + "'" + " with number " + tableNumber;
    }
}
