package com.prashanth.spring.geode.client;

import com.prashanth.spring.geode.common.Temperature;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@Log4j2
public class Runner implements ApplicationListener<ApplicationReadyEvent> {

    private final TemperatureRepository temperatureRepository;
    private final AverageTemperatureFunctionInvoker averageTemperatureFunctionInvoker;

    public Runner(TemperatureRepository temperatureRepository, AverageTemperatureFunctionInvoker averageTemperatureFunctionInvoker) {
        this.temperatureRepository = temperatureRepository;
        this.averageTemperatureFunctionInvoker = averageTemperatureFunctionInvoker;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // Cleanup existing data
        this.temperatureRepository
                .findAll()
                .forEach(this.temperatureRepository::delete);

        // Insert new record
        int randomOffset = new Random().nextInt(1000);
        for (int i = 0; i < randomOffset+100; i++) {
            this.insert();
        }

        // Get Cluster average
        Collection<Double> averages = this.averageTemperatureFunctionInvoker.averageTemperature();
        Double clusterAverageTemp = averages.stream().collect(Collectors.averagingDouble(t -> t));

        log.info("Cluster average "+ clusterAverageTemp);
    }

    private void insert() {
        Temperature temp = new Temperature(
                new Random().nextLong(),
                new Random().nextDouble(),
                randomCity()
        );

        this.temperatureRepository.save(temp);
    }

    private String randomCity() {
        String cities[] = ("San Jose, San Francisco, New Delhi, Mumbai, London, Paris, Copenhagen, San Deigo").split(",");
        return cities[new Random().nextInt(cities.length)];
    }
}
