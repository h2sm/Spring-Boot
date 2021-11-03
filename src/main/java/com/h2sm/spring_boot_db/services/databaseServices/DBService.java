package com.h2sm.spring_boot_db.services.databaseServices;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.models.Client;
import com.h2sm.spring_boot_db.repository.interfaces.AttendantsRepo;
import com.h2sm.spring_boot_db.repository.interfaces.ClientsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

        attendants.addAttendant(new Attendant(name, phoneNumber));
    }

    public void modifyAttendant(int id, String newName, String phoneNumber) {
        var att = attendants.returnAttendantByID(id);
        att.setName(newName);
        att.setPhoneNumber(phoneNumber);
        attendants.updateAttendant(att);
    }

    public void deleteAttendant(int id) {
        var att = attendants.returnAttendantByID(id);
        attendants.deleteAttendant(att);
    }

    public void addClient(Client c) {

    }

    public void modifyClient(Object... args) {

    }

    public void deleteClient(Object... args) {

    }
}
