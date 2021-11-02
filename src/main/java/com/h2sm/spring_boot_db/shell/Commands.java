package com.h2sm.spring_boot_db.shell;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.services.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Collection;
import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class Commands {
    private final DBService service;
    private final UI ui;
    //exiting a CLI
    @ShellMethod(value = "Shutting down a CLI", key = {"turnoff"})
    public void loggingOff() {
        System.exit(0);
    }

    //find all clients from database
    @ShellMethod(value = "Find all clients in database", key = {"find-all-clients", "clients"})
    public void findClients() {
        var col = service.getAllClients();
        print(col);
    }

    //find all clients by a name part
    @ShellMethod(value = "Find clients with given name or/and namepart", key = {"find-client-name", "client-name"})
    public void findClientsByName(@ShellOption(defaultValue = "") String name) {
        var col = service.getClientsByName(name);
        print(col);
    }

    //find all attendants
    @ShellMethod(value = "Return all registered attendants", key = {"find-all-attendants", "attendants", "soprovozhdayshiy"})
    public void findAttendants() {
        var col = service.getAllAttendants();
        print(col);
    }

    //find all attendants by a name part
    @ShellMethod(value = "Return all attendants with given name / part of name", key = {"find-attendant-name", "attendant-name"})
    public void findAttendantByName(@ShellOption(defaultValue = "") String name) {
        var col = service.getAttendantByName(name);
        print(col);
    }

    //add new attendant
    @ShellMethod(value = "Add a new attendant", key = {"add-attendant"})
    public void addAttendant(@ShellOption(defaultValue = "") String attendantName,
                             @ShellOption(defaultValue = "") String phoneNumber) {
        service.add(new Attendant(attendantName, phoneNumber));
    }

    //update an information about an attendant
    @ShellMethod(value = "Update an information about an attendant: " +
            "<attendant_name> + <desired_column_name> + <value>", key = {"upd-attendant"})
    public void updateAttendant(@ShellOption("--name") String name,
                                @ShellOption(value = "--columnName") String columnName,
                                @ShellOption("--settingValue")String value){
        var col = service.getAttendantByName(name);
        if (col.size() > 1){

        }
        //service.modify();
    }


    private void print(Collection<?> o) {
        ui.show(o);
    }
}
