package com.epam.products.runners;

import com.epam.framework.runner.ExtendedAbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@DependentGroup2","~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/DependentGroup2.json",
                "rerun:target/cucumber-results/Failed_DependentGroup2.txt"})
public class DependentGroup2 extends ExtendedAbstractTestNGCucumberTests {
}