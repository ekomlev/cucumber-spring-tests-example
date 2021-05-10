package com.eduard.config;


import org.springframework.context.annotation.Import;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;

@CucumberContextConfiguration
@Import({DriverConfig.class, UserConfig.class})
@Slf4j
public class CucumberSpringConfiguration {
}
