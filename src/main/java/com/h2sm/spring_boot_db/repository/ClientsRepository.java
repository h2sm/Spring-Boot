package com.h2sm.spring_boot_db.repository;

import com.h2sm.spring_boot_db.models.Client;
import com.h2sm.spring_boot_db.repository.interfaces.ClientsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Component
public class ClientsRepository implements ClientsRepo {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Collection<Client> returnAllClients() {
        return jdbc.query("""
                        select * from client;
                        """,
                Map.of("client_id", "full_name" + "passport" +  "tel_name" + "date_of_birth"),
                (rs, i) -> new Client(
                        rs.getInt("client_id"),
                        rs.getString("full_name"),
                        rs.getString("passport"),
                        rs.getString("tel_name"),
                        rs.getDate("date_of_birth")));
    }
}
