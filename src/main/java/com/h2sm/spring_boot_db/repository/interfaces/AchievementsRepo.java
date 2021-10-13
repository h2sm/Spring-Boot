package com.h2sm.spring_boot_db.repository.interfaces;

import com.h2sm.spring_boot_db.models.Achievement;

import java.util.Collection;

public interface AchievementsRepo {
    Collection<Achievement> returnAllAchievements();
}
