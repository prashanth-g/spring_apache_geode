package com.prashanth.spring.geode.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;

@SpringBootApplication
@EnableClusterConfiguration
public class CqApplication {
    public static void main(String[] args) {
        SpringApplication.run(CqApplication.class, args);
    }
}
