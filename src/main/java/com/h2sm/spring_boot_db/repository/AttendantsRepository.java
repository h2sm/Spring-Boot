package com.h2sm.spring_boot_db.repository;

import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.repository.interfaces.AttendantsRepo;

import java.util.Collection;

public class AttendantsRepository implements AttendantsRepo {
    @Override
    public Collection<Attendant> getAllAttendants() {
        return null;
    }
}
