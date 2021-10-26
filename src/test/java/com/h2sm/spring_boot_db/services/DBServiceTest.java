package com.h2sm.spring_boot_db.services;
import com.h2sm.spring_boot_db.config.SpringConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringConfig.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
class DBServiceTest {
    TestData data = new TestData();

    @MockBean
    AchievementsRepoImpl achievements;
    @MockBean
    StudentsRepoImpl studentsRepo;

    @Test
    void getAllTables() {
    }

    @Test
    void getAchievements() {
        Assertions.assertThat(data.returnAchievements()).containsAll(achievements.returnAllAchievements());
    }

    @Test
    void getAllStudents() {
        Assertions.assertThat(data.returnStudents()).containsAll(studentsRepo.getAllStudents());
    }
}