package com.h2sm.spring_boot_db.shell;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.services.databaseServices.DBService;
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

    //find all clients from database
    @ShellMethod(value = "Find all clients in database", key = {"find-all-clients", "clients"})
    public void findClients() {
        localize("shell.findClients");
        var col = service.getAllClients();
        print(col);
    }

    //find all clients by a name part
    @ShellMethod(value = "Find clients with given name or/and namepart", key = {"find-client-name", "client-name"})
    public void findClientsByName(@ShellOption(defaultValue = "") String name) {
        localize("shell.findClientsByName");
        var col = service.getClientsByName(name);
        print(col);
    }

    //find all attendants
    @ShellMethod(value = "Return all registered attendants", key = {"find-all-attendants", "attendants", "soprovozhdayshiy"})
    public void findAttendants() {
        localize("shell.findAttendants");
        var col = service.getAllAttendants();
        print(col);
    }

    //find all attendants by a name part
    @ShellMethod(value = "Return all attendants with given name / part of name", key = {"find-attendant-name", "attendant-name"})
    public void findAttendantByName(@ShellOption(defaultValue = "") String name) {
        localize("shell.findAttendantsByName");
        var col = service.getAttendantByName(name);
        print(col);
    }

    //add new attendant
    @ShellMethod(value = "Add a new attendant", key = {"add-att"})
    public void addAttendant(@ShellOption String attendantName,
                             @ShellOption String phoneNumber) {
        localize("shell.addAttendant");
        service.addAttendant(attendantName, phoneNumber);
    }

    //update an information about an attendant
    @ShellMethod(value = "Update an information about an attendant: " +
            "<attendant_name> + <desired_column_name> + <value>", key = {"upd-att"})
    public void updateAttendant(@ShellOption(value = "--id") int id,
                                @ShellOption(value = "--newName", defaultValue = "") String newName,
                                @ShellOption(value = "--newPhoneNumber") String phoneNumber) {
        localize("shell.updateAttendant");
        service.modifyAttendant(id, newName, phoneNumber);
    }
    @ShellMethod(value = "Delete an attendant", key = {"del-att"})
    public void deleteAttendant(@ShellOption(value = "--id") int id, boolean sure){
        localize("shell.deleteAttendant");
        if (sure) service.deleteAttendant(id);
        else localize("shell.sureBooleanFalse");

    }

    @ShellMethod(value = "Set locale", key = {"set-locale"})
    public void setLocale(@ShellOption(defaultValue = "en") String loc) {
        ui.setLocale(loc);
    }


    private void print(Collection<?> o) {
        ui.show(o);
    }

    private void print(String s) {
        ui.show(s);
    }

    private void localize(String loc){
        ui.showLocalized(loc);
    }
}
