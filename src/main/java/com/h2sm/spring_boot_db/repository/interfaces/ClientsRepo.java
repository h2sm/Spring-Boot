package com.h2sm.spring_boot_db.repository.interfaces;

import com.h2sm.spring_boot_db.models.Client;

import java.util.Collection;

public interface ClientsRepo {
    Collection<Client> returnAllClients();
}
