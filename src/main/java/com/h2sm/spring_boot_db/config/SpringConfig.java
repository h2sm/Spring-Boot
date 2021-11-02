package com.h2sm.spring_boot_db.config;

import com.h2sm.spring_boot_db.io.UI;
import com.h2sm.spring_boot_db.io.UserInterfaceImpl;
import com.h2sm.spring_boot_db.services.internationalization.LocaleService;
import com.h2sm.spring_boot_db.services.internationalization.MessageService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
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
//    @Bean//this bean is responsible for language tag setter and getter
//    public LocaleService localeService() {
//        return new LocaleService();
//    }
//
//    @Bean
//    public MessageService msgService() {//this bean encapsulates localeservice (basically a Locale Tag) and messagesourse(takes all the texts for different languages)
//        return new MessageService(messageSource(), localeService());
//    }
    @Bean//message source for taking localization packs in "resources" folder
    public MessageSource messageSource() {
        var src = new ReloadableResourceBundleMessageSource();
        src.setBasename("classpath:language-resourses");
        src.setDefaultEncoding("UTF-8");
        src.setCacheSeconds(900);
        src.setUseCodeAsDefaultMessage(true);
        return src;
    }
}
