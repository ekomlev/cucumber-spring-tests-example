package com.eduard.component.driver;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.eduard.component.properties.DriverProperties;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChromeDriver extends Driver {

  @Autowired
  public ChromeDriver(DriverProperties driverProperties) {
    super(driverProperties);
  }

  @Override
  public void setup() {
    List<String> driverArgs = Arrays.asList(
        "--disable-features=VizDisplayCompositor",
        "--disable-browser-side-navigation",
        "--ignore-certificate-errors",
        "--disable-machine-cert-request",
        "--ignore-urlfetcher-cert-requests",
        "--disable-gpu",
        "--allow-running-insecure-content");

    ChromeOptions options = new ChromeOptions();
    options.setAcceptInsecureCerts(true);
    options.setHeadless(driverProps.getHeadless());
    log.info("Using Chrome Headless: " + driverProps.getHeadless());

    options.addArguments(driverArgs);
    log.debug("Chrome arguments added: {}", driverArgs);

    driver = createDriver(options);

    setDimension();
    setTimeProperties();
  }

  @Override
  public <T extends MutableCapabilities> RemoteWebDriver createDriver(T options) {
    WebDriverManager.chromedriver().config().setUseBetaVersions(false);
    WebDriverManager.chromedriver().config()
        .setChromeDriverVersion(WebDriverManager.chromedriver().config().getChromeVersion());

    log.info("Setup driver " + driverProps.getBrowserType());
    WebDriverManager.chromedriver().setup();

    return new org.openqa.selenium.chrome.ChromeDriver((ChromeOptions) options);
  }
}