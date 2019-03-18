package com.prashanth.spring.geode.locator;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;

@Configuration
@EnableLocator
@EnableManager(start = true)
public class LocatorConfiguration {
}
