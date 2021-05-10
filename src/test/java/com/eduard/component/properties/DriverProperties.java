package com.eduard.component.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:driver.properties")
@Getter
@Setter
public class DriverProperties {

  @Value("${browser.type}")
  private String browserType;

  @Value("${browser.headless}")
  private Boolean headless;

  @Value("${browser.maximize}")
  private Boolean maximize;

  @Value("${browser.window.width}")
  private Integer width;

  @Value("${browser.window.height}")
  private Integer height;

  @Value("${browser.pageLoadTimeout}")
  private Integer pageLoadTimeout;

  @Value("${browser.elementLoadTimeout}")
  private Integer elementLoadTimeout;

  @Value("${browser.scriptTimeout}")
  private Integer scriptTimeout;

  @Value("${browser.reloadTimeout}")
  private Integer reloadTimeout;

  @Value("${browser.implicitlyWait}")
  private Integer implicitlyWait;

  @Value("${browser.uploadTimeout}")
  private Integer uploadTimeout;

  @Value("${browser.timeUnit}")
  private Integer timeUnit;
}