package com.prashanth.spring.geode.client;

import com.prashanth.spring.geode.common.Temperature;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Runner implements ApplicationListener<ApplicationReadyEvent> {

    private final TemperatureRepository temperatureRepository;

    public Runner(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // cleanup existing data
        this.temperatureRepository
                .findAll()
                .forEach(this.temperatureRepository::delete);

        // insert new record
        int randomOffset = new Random().nextInt(1000);
        for (int i = 0; i < randomOffset+100; i++) {
            this.insert();
        }
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
