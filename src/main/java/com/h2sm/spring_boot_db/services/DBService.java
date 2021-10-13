package com.h2sm.spring_boot_db.services;

import com.h2sm.spring_boot_db.models.Achievement;
import com.h2sm.spring_boot_db.models.Table;
import com.h2sm.spring_boot_db.repository.AchievementsRepo;
import com.h2sm.spring_boot_db.repository.TablesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;

@RequiredArgsConstructor
public class DBService {
    private final AchievementsRepo achievements;
    private final TablesRepo tables;

    public Collection<Table> getAllTables() {
        return tables.getAllTables();
    }

    public Collection<Achievement> getAchievements(){
        return achievements.returnAllAchievements();
    }
}
