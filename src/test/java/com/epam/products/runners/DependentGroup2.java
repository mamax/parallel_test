package com.epam.products.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@DependentGroup2","~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/DependentGroup2.json",
                "rerun:target/cucumber-results/Failed_DependentGroup2.txt"})
public class DependentGroup2 extends AbstractTestNGCucumberTests {
}