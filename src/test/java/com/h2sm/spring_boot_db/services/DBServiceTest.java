package com.h2sm.spring_boot_db.services;
import com.h2sm.spring_boot_db.config.SpringConfig;
import com.h2sm.spring_boot_db.repository.interfaces.AchievementsRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(classes = SpringConfig.class)
@Import(DBService.class)
class DBServiceTest {
    TestData data = new TestData();

    @Autowired
    AchievementsRepo achievements;

    @Test
    void getAllTables() {
    }

    @Test
    void getAchievements() {
        Assertions.assertThat(data.returnAchievements()).containsExactlyElementsOf(achievements.returnAllAchievements().stream().toList());
    }

    @Test
    void getAllStudents() {
    }
}