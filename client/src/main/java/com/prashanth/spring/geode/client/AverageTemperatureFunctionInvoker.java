package com.prashanth.spring.geode.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.function.annotation.OnRegion;

import java.util.Collection;

@OnRegion(region = "temps")
public interface AverageTemperatureFunctionInvoker {

    Collection<Double> averageTemperature();

}
