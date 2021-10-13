package com.h2sm.spring_boot_db.repository;

import com.h2sm.spring_boot_db.models.Achievement;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AchievementsRepoImpl implements AchievementsRepo {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Collection<Achievement> returnAllAchievements() {
        return jdbc.query("""
                        select achievements_id, achievement from achievements
                        """,
                Map.of("achievements_id", "achievement"),
                (rs, i) -> new Achievement(
                        rs.getInt("achievements_id"),
                        rs.getString("achievement")));
    }
}
