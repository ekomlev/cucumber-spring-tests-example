#Overview

Stack:
- Java 11
- Spring 5
- Selenium 3
- Webdrivermanager 4
- Cucumber 6
- Junit 4

In this example it is shown how Cucumber works with Spring.<br>
Parallel execution is possible with the help of `maven-surefire-plugin`.<br>
Also it's not possible to use Spring autowire in Unit test (see `src/tests/UserUnitTest`) when Cucumber context is not running. `@ScenarioScope` annotation is used in com.eduard.config to define bean scope.
Spring context doesn't know about it.
<br><br>
To run in parallel:
```
mvn clean test -DthreadCount=2 -Dbrowser.type=chrome
```
