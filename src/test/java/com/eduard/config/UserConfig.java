package com.eduard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.eduard.component.pojo.User;

import io.cucumber.spring.ScenarioScope;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Lazy
@Configuration
@ComponentScan({"com.eduard.component.pojo"})
public class UserConfig {
  @Bean
  @ScenarioScope
  public User user() {
    User user = new User("John Wick", 22);
    log.info("User {} is created", user);
    return user;
  }
}
