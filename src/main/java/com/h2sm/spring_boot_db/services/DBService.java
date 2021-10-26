package com.h2sm.spring_boot_db.services;

import com.h2sm.spring_boot_db.models.Client;
import com.h2sm.spring_boot_db.repository.interfaces.ClientsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service("dbserv")
public class DBService {
    private final ClientsRepo clients;

    public Collection<Client> getAllClients() {
        return clients.returnAllClients();
    }

}
