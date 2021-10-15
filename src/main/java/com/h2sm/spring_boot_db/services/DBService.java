package com.h2sm.spring_boot_db.services;

import com.h2sm.spring_boot_db.models.Achievement;
import com.h2sm.spring_boot_db.models.Student;
import com.h2sm.spring_boot_db.models.Table;
import com.h2sm.spring_boot_db.repository.interfaces.AchievementsRepo;
import com.h2sm.spring_boot_db.repository.interfaces.StudentsRepo;
import com.h2sm.spring_boot_db.repository.interfaces.TablesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service("dbserv")
public class DBService {
    private final AchievementsRepo achievements;
    private final TablesRepo tables;
    private final StudentsRepo students;

    public Collection<Table> getAllTables() {
        return tables.getAllTables();
    }

    public Collection<Achievement> getAchievements() {
        return achievements.returnAllAchievements();
    }

    public Collection<Student> getAllStudents() {
        return students.getAllStudents();
    }
}
