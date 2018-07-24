package com.epam.products.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@SynchronizedGroup1","~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/SynchronizedGroup1.json",
                "rerun:target/cucumber-results/SynchronizedGroup1.txt"})
public class SynchronizedGroup1 extends AbstractTestNGCucumberTests {
}