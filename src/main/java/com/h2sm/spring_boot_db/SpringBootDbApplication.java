package com.h2sm.spring_boot_db;

import com.h2sm.spring_boot_db.config.DockerAuth;
import com.h2sm.spring_boot_db.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootDbApplication {

    public static void main(String[] args) {
        // TODO: 11.10.2021 1) shell команды
        // TODO: 11.10.2021 2) jdbc-template для postgres
        // TODO: 11.10.2021 3) интернационализация
        SpringApplication.run(SpringConfig.class, args);

    }

}
