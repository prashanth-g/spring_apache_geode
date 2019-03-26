package com.prashanth.spring.geode.locator;

import com.prashanth.spring.geode.server.fn.AverageTemperatureFunctionImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;

@CacheServerApplication(locators = "localhost[10334]")
@SpringBootApplication
@ComponentScan(basePackageClasses = { LocatorApplication.class, AverageTemperatureFunctionImpl.class} )
public class LocatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocatorApplication.class, args);
    }
}
