package com.h2sm.spring_boot_db.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class Commands {
    @ShellMethod(value = "stop", key = "stop")
    public void stop() {
        System.exit(0);
    }
    @ShellMethod(value = "find", key = "find")
    public void findAchievement() {

    }
    @ShellMethod(value = "findAll", key = "find-all")
    public void findAll() {
        System.out.println("find -all");
    }
}
