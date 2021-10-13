package com.h2sm.spring_boot_db.config;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.io.UserInterfaceImpl;
import com.h2sm.spring_boot_db.repository.StudentsRepoImpl;
import com.h2sm.spring_boot_db.repository.interfaces.AchievementsRepo;
import com.h2sm.spring_boot_db.repository.AchievementsRepoImpl;
import com.h2sm.spring_boot_db.repository.interfaces.StudentsRepo;
import com.h2sm.spring_boot_db.repository.interfaces.TablesRepo;
import com.h2sm.spring_boot_db.repository.TablesRepoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("/docker_credits.properties")
public class SpringConfig {
    @Bean
    public DockerAuth auth() {//docker auth encapsulation
        return new DockerAuth();
    }

    @Bean
    public DataSource postgresDataSource() {//datasource for postgres
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(auth().getUrl());
        dataSource.setUsername(auth().getLogin());
        dataSource.setPassword(auth().getPass());
        return dataSource;
    }

    @Bean
    public UI userInterface() {
        return new UserInterfaceImpl();
    }

    @Bean
    public NamedParameterJdbcOperations jdbcOperations() {
        return new NamedParameterJdbcTemplate(postgresDataSource());
    }

//    @Bean
//    public AchievementsRepo achievements() {
//        return new AchievementsRepoImpl(jdbcOperations());
//    }
//
//    @Bean
//    public TablesRepo tables() {
//        return new TablesRepoImpl(jdbcOperations());
//    }
//
//    @Bean
//    public StudentsRepo student() {
//        return new StudentsRepoImpl(jdbcOperations());
//    }
}
