package com.funs4hrs.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@EntityScan(basePackages = {"com.funs4hrs"})
@ComponentScan(basePackages = {"com.funs4hrs"})
@EnableJpaRepositories(basePackages = {"com.funs4hrs"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
