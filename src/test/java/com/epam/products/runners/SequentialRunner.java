package com.epam.products.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/SequentialRunner.json",
                "rerun:target/cucumber-results/Failed_SequentialRunner.txt"})
public class SequentialRunner extends AbstractTestNGCucumberTests {
}