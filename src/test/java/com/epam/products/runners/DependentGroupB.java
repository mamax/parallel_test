package com.epam.products.runners;

import com.epam.framework.runner.ExtendedAbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@DependentGroupB", "~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/DependentGroupB.json",
                "rerun:target/cucumber-results/Failed_DependentGroup2.txt"})
public class DependentGroupB extends ExtendedAbstractTestNGCucumberTests {
}