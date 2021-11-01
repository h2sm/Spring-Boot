package com.h2sm.spring_boot_db.repository;

import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.repository.interfaces.AttendantsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
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

    @Override
    public void addNewAttendant(Attendant a) {
//        a.
//        var sql = "insert into attendant values :"

    }

    @Override
    public void modifyAttendant(Attendant a) {

    }

    @Override
    public void deleteAttendant(Attendant a) {

    }

}
