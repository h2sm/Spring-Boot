package com.h2sm.spring_boot_db.config;

import com.h2sm.spring_boot_db.io.UserOutput;
import com.h2sm.spring_boot_db.io.UserOutputImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
    public UserOutput out() {
        return new UserOutputImpl();
    }
}
