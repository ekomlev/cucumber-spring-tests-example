package com.eduard.stepDefs;

import org.junit.Assume;
import org.springframework.beans.factory.annotation.Autowired;

import com.eduard.component.driver.Driver;
import com.eduard.component.pojo.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OpenWebsitesStepDefinition {

  @Autowired
  private Driver driver;

  @Autowired
  private User user;

  @Given("User {string} is created")
  public void userIsCreated(String expectedUser) {
    log.info("-------->>>>>>>>>  Thread ID - {} 2d - from feature file.\n", Thread.currentThread().getId());
    Assume.assumeTrue(expectedUser.equals(user.getName()));
  }

  @Then("I should be taken to {string}")
  public void openWebsite(String page) {
    log.info("Opening website {}", page);
    driver.get(page);
  }
}
