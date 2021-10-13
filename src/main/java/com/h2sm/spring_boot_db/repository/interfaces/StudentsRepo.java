package com.h2sm.spring_boot_db.repository.interfaces;

import com.h2sm.spring_boot_db.models.Student;

import java.util.Collection;

public interface StudentsRepo {
    Collection<Student> getAllStudents();
}
