package com.epam.products.runners;

import com.epam.framework.runner.ExtendedAbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@DependentGroup1","~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/DependentGroup1.json",
                "rerun:target/cucumber-results/Failed_DependentGroup1.txt"})
public class DependentGroup1 extends ExtendedAbstractTestNGCucumberTests {
}