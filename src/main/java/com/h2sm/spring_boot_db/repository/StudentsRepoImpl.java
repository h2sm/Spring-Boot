package com.h2sm.spring_boot_db.repository;

import com.h2sm.spring_boot_db.models.Student;
import com.h2sm.spring_boot_db.repository.interfaces.StudentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StudentsRepoImpl implements StudentsRepo {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Collection<Student> getAllStudents() {
        return jdbc.query("""
                        	select s.student_id, s.age, s.full_name, o.group_name, s.email, s.is_chef from student s, onegroup o where s.group_id=o.onegroup_id  
                        """,
                Map.of("student_id", "full_name" + "age" + "group_name" + "email" + "is_chef"),
                (rs, i) -> new Student(rs.getInt("student_id"),
                        rs.getInt("age"),
                        rs.getString("full_name"),
                        rs.getString("group_name"),
                        rs.getString("email"),
                        rs.getBoolean("is_chef")));
    }
}
