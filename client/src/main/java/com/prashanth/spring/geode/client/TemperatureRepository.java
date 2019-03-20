package com.prashanth.spring.geode.client;

import com.prashanth.spring.geode.common.Temperature;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
}
