package com.prashanth.spring.geode.server;

import com.prashanth.spring.geode.common.Temperature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;

@SpringBootApplication
@CacheServerApplication(locators = "localhost[10334]")
@ComponentScan(basePackageClasses = {ServerApplication.class, Temperature.class})
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
