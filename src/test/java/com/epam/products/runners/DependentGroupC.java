package com.epam.products.runners;

import com.epam.framework.runner.ExtendedAbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@DependentGroupC", "~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/DependentGroupC.json",
                "rerun:target/cucumber-results/Failed_DependentGroupC.txt"})
public class DependentGroupC extends ExtendedAbstractTestNGCucumberTests {
}