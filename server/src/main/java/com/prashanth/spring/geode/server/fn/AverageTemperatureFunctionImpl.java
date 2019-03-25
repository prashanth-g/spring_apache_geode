package com.prashanth.spring.geode.server.fn;

import com.prashanth.spring.geode.common.Temperature;
import org.springframework.data.gemfire.function.annotation.GemfireFunction;
import org.springframework.data.gemfire.function.annotation.RegionData;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AverageTemperatureFunctionImpl {

    @GemfireFunction
    public void averageTemperature(@RegionData Map<String, Temperature> data) {}

}
