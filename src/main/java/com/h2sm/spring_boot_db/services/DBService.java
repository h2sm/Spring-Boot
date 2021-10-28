package com.h2sm.spring_boot_db.services;

import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.models.Client;
import com.h2sm.spring_boot_db.repository.interfaces.AttendantsRepo;
import com.h2sm.spring_boot_db.repository.interfaces.ClientsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service("dbserv")
public class DBService {
    private final ClientsRepo clients;
    private final AttendantsRepo attendants;

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
}
