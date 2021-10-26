package com.h2sm.spring_boot_db.repository.interfaces;

import com.h2sm.spring_boot_db.models.Attendant;

import java.util.Collection;

public interface AttendantsRepo {
    Collection<Attendant> getAllAttendants();
}
