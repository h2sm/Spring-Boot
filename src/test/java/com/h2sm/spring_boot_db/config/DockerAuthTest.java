package com.h2sm.spring_boot_db.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import static org.junit.jupiter.api.Assertions.*;
@TestComponent
@SpringBootTest
class DockerAuthTest {
    private final String login = "docker";
    private final String pass = "docker";
    private final String url = "jdbc:postgresql:docker";
    @Qualifier("auth")
    @SuppressWarnings({"SpringJavaAutowiringInspection"})
    @Autowired
    private DockerAuth da;
    @Test
    void getLogin() {
        assertEquals(login, da.getPass());
    }

    @Test
    void getPass() {
        assertEquals(pass, da.getPass());
    }

    @Test
    void getUrl() {
        assertEquals(url, da.getUrl());
    }
}