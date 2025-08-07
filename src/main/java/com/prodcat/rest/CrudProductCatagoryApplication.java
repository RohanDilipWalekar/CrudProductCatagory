package com.prodcat.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.prodcat.entity")
@ComponentScan(basePackages = {"com.prodcat.controller", "com.prodcat.repository", "com.prodcat.service","com.prodcat.dto"})
@EnableJpaRepositories(basePackages = "com.prodcat.repository")
public class CrudProductCatagoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudProductCatagoryApplication.class, args);
    }
}
