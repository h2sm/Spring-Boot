package com.h2sm.spring_boot_db.services;

import com.h2sm.spring_boot_db.models.Achievement;
import lombok.Getter;
import org.springframework.boot.test.context.TestComponent;

import java.util.List;

@TestComponent
public class TestData {
    private final Achievement ac1 = new Achievement(0, "Получил стипендию");
    private final Achievement ac2 = new Achievement(1, "Сдал матешу на 5");
    private final Achievement ac3 = new Achievement(2, "Сдал ГТО");
    public final List<Achievement> achievementList = List.of(ac1, ac2, ac3);

    public List<Achievement> returnAchievements() {
        return achievementList;
    }

}
