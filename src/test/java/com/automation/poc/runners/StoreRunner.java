package com.automation.poc.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber/test-report","json:target/cucumber-report.json"},
        glue = "com.automation.poc")

public class StoreRunner {


}
