package com.epam.products.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@DependentGroupA","~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/DependentGroupA.json",
                "rerun:target/cucumber-results/Failed_DependentGroupA.txt"})
public class DependentGroupA extends AbstractTestNGCucumberTests {
}