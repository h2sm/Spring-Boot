package com.h2sm.spring_boot_db.services.databaseServices;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.models.Client;
import com.h2sm.spring_boot_db.repository.interfaces.AttendantsRepo;
import com.h2sm.spring_boot_db.repository.interfaces.ClientsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service("dbserv")
public class DBService {
    private final ClientsRepo clients;
    private final AttendantsRepo attendants;
    private final UI ui;

    public Collection<Client> getAllClients() {
        return clients.returnAllClients();
    }

    public Collection<Client> getClientsByName(String name) {
        return clients.returnClientByNamePart(name);
    }

    public Collection<Attendant> getAllAttendants() {
        return attendants.getAllAttendants();
    }

    public Collection<Attendant> getAttendantByName(String name) {
        return attendants.getAttendantByName(name);
    }

    public void addAttendant(String name, String phoneNumber) {

        attendants.addAttendant(name,phoneNumber);
    }

    public void add(Client c) {

    }

    public void modify(String name, String columnName, String value) {
        var col = attendants.getAttendantByName(name);
        var numberOfPersons = col.size();
        if (numberOfPersons > 1) {
            System.out.println(ui.returnLocalized("shell.sameNamesHelp"));
            System.out.println(col);
            var searchingAttendantID = ui.getKeyboard();
            var attendant = col.stream().filter(a -> a.getId() == Integer.parseInt(searchingAttendantID)).findFirst().get();
            System.out.println("updating an attendant " + attendant);
        } else if (numberOfPersons == 1) {
            System.out.println("модифицирую " + new ArrayList<>(col).get(0));
        } else {
            System.out.println("бля");
        }
        //
    }

    public void modify(Client c) {

    }

    public void delete(Attendant a) {

    }

    public void delete(Client c) {

    }
}
