package com.h2sm.spring_boot_db.io;

import com.h2sm.spring_boot_db.models.Achievement;
import com.h2sm.spring_boot_db.models.Table;

import java.util.Collection;

public interface UI {
    void show(String str);
    void show(Collection<Object> t);
    void showLocalized(String str);
}
