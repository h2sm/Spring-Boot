package com.h2sm.spring_boot_db.repository.interfaces;

import com.h2sm.spring_boot_db.models.Attendant;

import java.util.Collection;

public interface AttendantsRepo {
    Collection<Attendant> getAllAttendants();
    Collection<Attendant> getAttendantByName(String name);
    Attendant returnAttendantByID(int id);
    void addAttendant(Attendant a);
    void updateAttendant(Attendant a);
    void deleteAttendant(Attendant a);
}
