package com.eduard.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"json:target/cucumber.json", "pretty"},
//    features = {"classpath:Open_Github_Google.feature"},
//    features = {"classpath:Open_Github_Google.feature"},
        features = {"src/test/resources/features"},
//    features = "src/test/features/smoke",
    glue = "com.eduard",
      tags = "@test"
)
@Slf4j
public class CucumberRunnerTest {
}