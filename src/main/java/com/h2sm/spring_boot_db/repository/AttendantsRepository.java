package com.h2sm.spring_boot_db.repository;

import com.h2sm.spring_boot_db.models.Attendant;
import com.h2sm.spring_boot_db.repository.interfaces.AttendantsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    private final static RowMapper<Attendant> MAPPER = (rs, num) ->
            new Attendant(rs.getInt("attendant_id"),
                    rs.getString("attendant_name"),
                    rs.getString("tel_number")
            );

    @Override
    public Collection<Attendant> getAllAttendants() {
        var sql = "select * from attendant";
        return jdbc.query(sql, MAPPER);
    }

    @Override
    public Collection<Attendant> getAttendantByName(String name) {
        var sql = "select * from attendant a where a.attendant_name = " + "\'" + name + "\'";
        return jdbc.query(sql, MAPPER);
    }

    @Override
    public Attendant returnAttendantByID(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("attendant_id", id);
        var sql = "select * from attendant where attendant_id =:attendant_id";
        return jdbc.query(sql,
                Map.of("attendant_id", id),
                (v, rs) -> new Attendant(v.getInt("attendant_id"),
                        v.getString("attendant_name"),
                        v.getString("tel_number")
                        )).get(0);

    }

    public void addAttendant(Attendant a) {
        var params = new MapSqlParameterSource();
        params.addValue("attendant_name", a.getName());
        params.addValue("tel_number", a.getPhoneNumber());
        var sql = "insert into attendant (attendant_name, tel_number) values (:attendant_name, :tel_number)";
        jdbc.update(sql, params);
    }

    @Override
    public void updateAttendant(Attendant a) {
        var params = new MapSqlParameterSource();
        params.addValue("attendant_name", a.getName());
        params.addValue("tel_number", a.getPhoneNumber());
        params.addValue("attendant_id", a.getId());
        var sql = "update attendant set attendant_name = :attendant_name, tel_number = :tel_number where attendant_id=:attendant_id";
        jdbc.update(sql, params);
    }

    @Override
    public void deleteAttendant(Attendant a) {
        var params = new MapSqlParameterSource();
        params.addValue("attendant_name", a.getName());
        params.addValue("tel_number", a.getPhoneNumber());
        params.addValue("attendant_id", a.getId());
        var sql = "delete from attendant where attendant_id =:attendant_id";
        jdbc.update(sql,params);
    }

}
