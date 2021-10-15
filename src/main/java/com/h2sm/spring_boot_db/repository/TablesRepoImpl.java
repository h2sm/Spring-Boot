package com.h2sm.spring_boot_db.repository;

import com.h2sm.spring_boot_db.models.Table;
import com.h2sm.spring_boot_db.repository.interfaces.TablesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Component
public class TablesRepoImpl implements TablesRepo {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Collection<Table> getAllTables() {
        return jdbc.query("""
                        SELECT t.tablename, ROW_NUMBER() OVER (ORDER BY (SELECT 1)) AS number FROM pg_catalog.pg_tables AS t where schemaname = 'public'
                        """,
                Map.of("number", "tablename"),
                (rs, i) -> new Table(
                        rs.getInt("number"),
                        rs.getString("tablename")));
    }
}
