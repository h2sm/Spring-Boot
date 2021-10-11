package com.h2sm.spring_boot_db.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class DockerAuth {
    @Value("${docker.Login}")
    private String login;
    @Value("${docker.Password}")
    private String pass;
    @Value("${docker.URL}")
    private String url;
}
