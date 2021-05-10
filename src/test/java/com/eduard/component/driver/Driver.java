package com.eduard.component.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.eduard.component.properties.DriverProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Driver extends RemoteWebDriver {
  DriverProperties driverProps;
  protected RemoteWebDriver driver;

  protected Driver(DriverProperties properties) {
    this.driverProps = properties;
  }

  public abstract void setup();

  public abstract <T extends MutableCapabilities> WebDriver createDriver(T options);

  public void setDimension() {
    if (driverProps.getMaximize()) {
      maximizeWindow();
    } else {
      setWindowSize(new Dimension(driverProps.getWidth(), driverProps.getHeight()));
    }
  }

  public void maximizeWindow() {
    driver.manage().window().maximize();
    log.info("Browser window size: Width: {}, Height: {}", driver.manage().window().getSize().getWidth(), driver.manage().window().getSize().getHeight());
  }

  public void setWindowSize(Dimension dimension) {
    driver.manage().window().setSize(dimension);
    log.info("Browser window size: Width: {}, Height: {}", driver.manage().window().getSize().getWidth(), driver.manage().window().getSize().getHeight());
  }

  void setTimeProperties() {
    log.info("Setting timeouts to webdriver: ImplicitlyWait {}, PageLoadTimeout{}, ScriptTimeout{}", driverProps.getImplicitlyWait(),
        driverProps.getPageLoadTimeout(), driverProps.getScriptTimeout());
    driver.manage().timeouts().implicitlyWait(driverProps.getImplicitlyWait(), TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(driverProps.getPageLoadTimeout(), TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(driverProps.getScriptTimeout(), TimeUnit.SECONDS);
  }

  @Override
  public void get(String url) {
    log.info("Opening: {}", url);
    driver.get(url);
  }

  @Override
  public void close() {
    driver.close();
  }

  @Override
  public void quit() {
    log.info("Webdriver is going to quit");
    driver.quit();
  }
}