package com.eduard.config;


import org.springframework.context.annotation.Import;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;

//import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@CucumberContextConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@Scope(SCOPE_CUCUMBER_GLUE)
//@ContextConfiguration(classes = CucContextConfig.class)
@Import({DriverConfig.class, UserConfig.class/*, CucContextConfig.class*/})
@Slf4j
public class CucumberSpringConfiguration {
}
