package com.epam.products.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@DependentGroupB","~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/DependentGroupB.json",
                "rerun:target/cucumber-results/Failed_DependentGroupB.txt"})
public class DependentGroupB extends AbstractTestNGCucumberTests {
}