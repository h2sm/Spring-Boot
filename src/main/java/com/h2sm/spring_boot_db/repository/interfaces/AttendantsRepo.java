package com.h2sm.spring_boot_db.repository.interfaces;

import com.h2sm.spring_boot_db.models.Attendant;

import java.util.Collection;

public interface AttendantsRepo {
    Collection<Attendant> getAllAttendants();
    Collection<Attendant> getAttendantByName(String name);
    void addNewAttendant(Attendant a);
    void modifyAttendant(Attendant a);
    void deleteAttendant(Attendant a);
}
