package com.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.automation.poc.services","com.automation.poc.steps"})
public class Application {

    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
    }

}
