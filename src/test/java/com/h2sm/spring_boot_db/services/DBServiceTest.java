package com.h2sm.spring_boot_db.services;
import com.h2sm.spring_boot_db.SpringBootDbApplication;
import com.h2sm.spring_boot_db.config.SpringConfig;
import com.h2sm.spring_boot_db.repository.interfaces.AchievementsRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringConfig.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
class DBServiceTest {
    TestData data = new TestData();

    @MockBean
    AchievementsRepo achievements;

    @Test
    void getAllTables() {
    }

    @Test
    void getAchievements() {
        achievements.returnAllAchievements().forEach(System.out::println);
        Assertions.assertThat(data.returnAchievements()).containsExactlyElementsOf(achievements.returnAllAchievements().stream().toList());
    }

    @Test
    void getAllStudents() {
    }
}