package com.eduard.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import com.eduard.component.driver.ChromeDriver;
import com.eduard.component.driver.Driver;
import com.eduard.component.properties.DriverProperties;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Lazy
@Configuration
@PropertySource("classpath:driver.properties")
@ComponentScan("com.eduard.component.properties")
public class DriverConfig {

  @Bean(destroyMethod = "quit", initMethod = "setup")
  @ConditionalOnExpression("'chrome'.equals('${browser.type}')")
  @ScenarioScope
  public Driver chromeDriver(DriverProperties driverProps) {
    Driver dr = new ChromeDriver(driverProps);

    log.info("-->> chromeDriver CREATING. Thread ID - {}. CHROME INSTANCE - {}.",
        Thread.currentThread().getId(), dr.hashCode());

    return dr;
  }
}