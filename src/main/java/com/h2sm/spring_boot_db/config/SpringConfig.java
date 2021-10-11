package com.h2sm.spring_boot_db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("/docker_credits.properties")
public class SpringConfig {
    @Bean
    public DockerAuth auth() {
        return new DockerAuth();
    }
}
