package com.h2sm.spring_boot_db.shell;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.services.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Collection;

@ShellComponent
@RequiredArgsConstructor
public class Commands {
    private final DBService service;
    private final UI ui;

    @ShellMethod(value = "logOff", key = {"turnoff"})
    public void loggingOff() {
        System.exit(0);
    }

    @ShellMethod(value = "find-client", key = {"find", "client"})
    public void findClients() {
        var col = service.getAllClients();
        print(col);
    }
    @ShellMethod(value = "find-attendants", key = {"attendants", "attendant", "soprovozhdayshiy"})
    public void findAttendants(){
        var col = service.getAllAttendants();
        print(col);
    }

    private void print(Collection<?> o) {
        ui.show(o);
    }
}
