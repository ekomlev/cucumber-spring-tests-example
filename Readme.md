# Cucumber-Spring Test Framework example

## Stack

Stack:
- Java 11
- Spring 5
- Selenium 3
- Webdrivermanager 4
- Cucumber 6
- Junit 4

## Overview
In this example it is shown how Cucumber works with Spring.<br>
Parallel execution is possible with the help of `maven-surefire-plugin`.<br>
Also it's not possible to use Spring autowire in Unit test (see `src/unitTests/UserTest`) when Cucumber context is not running. `@ScenarioScope` annotation is used in com.eduard.config to define bean scope.
Spring context doesn't know about it.
<br><br>

## Run
1. Execute `com.eduard.runners.CucumberRunnerTest`
2. To run in parallel, use command line:
```
mvn clean test -DthreadCount=2 -Dbrowser.type=chrome
```
