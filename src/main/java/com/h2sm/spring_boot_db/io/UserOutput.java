package com.h2sm.spring_boot_db.io;

import com.h2sm.spring_boot_db.models.Achievements;

public interface UserOutput {
    void show(String str);
    void show(Achievements a);
}
