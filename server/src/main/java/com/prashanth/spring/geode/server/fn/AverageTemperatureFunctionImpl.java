package com.prashanth.spring.geode.server.fn;

import com.prashanth.spring.geode.common.Temperature;
import org.springframework.data.gemfire.function.annotation.GemfireFunction;
import org.springframework.data.gemfire.function.annotation.RegionData;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AverageTemperatureFunctionImpl {

    @GemfireFunction
    public Double averageTemperature(@RegionData Map<String, Temperature> data) {
        Double average = data.values()
                        .stream()
                        .map(Temperature::getTemperature)
                        .collect(Collectors.averagingDouble(x -> x));

        return average;
    }

}
