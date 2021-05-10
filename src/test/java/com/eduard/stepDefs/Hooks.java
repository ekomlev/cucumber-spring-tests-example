package com.eduard.stepDefs;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.eduard.component.driver.Driver;
import com.eduard.config.DriverConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Import({DriverConfig.class})
//@ComponentScan("com.eduard")
public class Hooks {
  @Autowired
  private Driver driver;

  @Autowired
  private ApplicationContext appContext;

  @Before()
  public void setup() {
    log.info("\n\n-------->>>>>>>>> BEFORE STEP. Thread ID - {}. CHROME INSTANCE - {}.\n\n", Thread.currentThread().getId(), driver.hashCode());

    Map<String, Driver> drivers = appContext.getBeansOfType(Driver.class);
    log.info("\n\n CucumberSpringConfiguration. DRIVER INSTANCES: \n{}\n\n", drivers);
  }

  @After()
  public void tearDown() {
    log.info("\n\n-------->>>>>>>>> AFTER STEP. Thread ID - {}. CHROME INSTANCE - {}.\n\n", Thread.currentThread().getId(), driver.hashCode());
  }
}