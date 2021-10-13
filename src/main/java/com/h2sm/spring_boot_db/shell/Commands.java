package com.h2sm.spring_boot_db.shell;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.services.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Collection;
import java.util.Collections;

@ShellComponent
@RequiredArgsConstructor
public class Commands {
    private final DBService service;
    private final UI ui;

    @ShellMethod(value = "logOff", key = {"turnoff"})
    public void loggingOff() {
        System.exit(0);
    }

    @ShellMethod(value = "find-Achievement", key = {"find", "achievement"})
    public void findAchievement() {
        var ac = service.getAchievements();
        print(Collections.singleton(ac));
    }

    @ShellMethod(value = "find-all-Tables", key ="all")
    public void findAllTables() {
        System.out.println("find -all");
    }

    private void print(Collection<Object> o) {
        ui.show(o);
    }
}
