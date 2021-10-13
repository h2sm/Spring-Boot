package com.h2sm.spring_boot_db.repository.interfaces;

import com.h2sm.spring_boot_db.models.Table;

import java.util.Collection;

public interface TablesRepo {
    Collection<Table> getAllTables();
}
