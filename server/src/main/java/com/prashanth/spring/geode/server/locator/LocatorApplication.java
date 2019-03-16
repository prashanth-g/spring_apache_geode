package com.prashanth.spring.geode.server.locator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;

@CacheServerApplication
@SpringBootApplication
public class LocatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocatorApplication.class, args);
    }
}
