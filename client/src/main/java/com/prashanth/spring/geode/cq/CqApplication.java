package com.prashanth.spring.geode.cq;

import org.apache.geode.cache.query.CqEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.EnableClusterConfiguration;
import org.springframework.data.gemfire.listener.annotation.ContinuousQuery;

import java.util.Optional;

@SpringBootApplication
@EnableClusterConfiguration
public class CqApplication {
    public static void main(String[] args) {
        SpringApplication.run(CqApplication.class, args);
    }

    @ContinuousQuery(name = "temperature-readings",
        query = "select * from /temps where city.contains('San')"
    )
    public void onNewTemperature(CqEvent event) {
        Optional.ofNullable(event)
                .map(CqEvent::getNewValue)
                .ifPresent(temp -> System.out.println(temp.toString()));
    }
}
