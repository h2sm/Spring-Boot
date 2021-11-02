package com.h2sm.spring_boot_db.repository;

import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.repository.interfaces.AttendantsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Component
public class AttendantsRepository implements AttendantsRepo {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Collection<Attendant> getAllAttendants() {
        return jdbc.query("""
                        select * from attendant;
                        """, Map.of("attendant_id", "attendant_name" + "tel_number"),
                (rs, i) -> new Attendant(
                        rs.getInt("attendant_id"),
                        rs.getString("attendant_name"),
                        rs.getString("tel_number")
                ));
    }

    @Override
    public Collection<Attendant> getAttendantByName(String name) {
        var sql = "select * from attendant a where a.attendant_name = " + "\'" + name + "\'";
        return jdbc.query(sql, Map.of("attendant_id", "attendant_name" + "tel_number"),
                (rs, i) -> new Attendant(
                        rs.getInt("attendant_id"),
                        rs.getString("attendant_name"),
                        rs.getString("tel_number")
                ));
    }

    public void addAttendant(Attendant a) {
        var params = new MapSqlParameterSource();
        params.addValue("attendant_name", a.getName());
        params.addValue("tel_number", a.getPhoneNumber());
        var sql = "insert into attendant (attendant_name, tel_number) values (:name, :phoneNumber)";
        jdbc.update(sql, params);
    }

}
