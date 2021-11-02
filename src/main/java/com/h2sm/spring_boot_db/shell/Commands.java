package com.h2sm.spring_boot_db.shell;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.services.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Collection;

@ShellComponent
@RequiredArgsConstructor
public class Commands {
    private final DBService service;
    private final UI ui;
    //exiting a CLI
    @ShellMethod(value = "logOff", key = {"turnoff"})
    public void loggingOff() {
        System.exit(0);
    }

    //find all clients from database
    @ShellMethod(value = "find-all-client", key = {"find-all-clients", "clients"})
    public void findClients() {
        var col = service.getAllClients();
        print(col);
    }

    //find all clients by a name part
    @ShellMethod(value = "find-client-name", key = {"find-client-name", "client-name"})
    public void findClientsByName(@ShellOption(defaultValue = "") String name) {
        var col = service.getClientsByName(name);
        print(col);
    }

    //find all attendants
    @ShellMethod(value = "find-all-attendants", key = {"find-all-attendants", "attendants", "soprovozhdayshiy"})
    public void findAttendants() {
        var col = service.getAllAttendants();
        print(col);
    }

    //find all attendants by a name part
    @ShellMethod(value = "find-att-by-name", key = {"find-attendant-name", "attendant-name"})
    public void findAttendantByName(@ShellOption(defaultValue = "") String name) {
        var col = service.getAttendantByName(name);
        print(col);
    }

    //add new attendant
    @ShellMethod(value = "add-attendant", key = {"add-attendant"})
    public void addAttendant(@ShellOption(defaultValue = "") String attendantName,
                             @ShellOption(defaultValue = "") String phoneNumber) {
        service.add(new Attendant(attendantName, phoneNumber));
    }

    //update an information about an attendant
    @ShellMethod(value = "upd-attendant", key = {"upd-attendant"})
    public void updateAttendant(@ShellOption(defaultValue="") int id){
        //service.modify();
    }

    private void print(Collection<?> o) {
        ui.show(o);
    }
}
