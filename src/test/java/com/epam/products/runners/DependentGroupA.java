package com.epam.products.runners;

import com.epam.framework.runner.ExtendedAbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/cucumber/",
        glue = "com.epam.products.tests",
        tags = {"@DependentGroupA", "~@Ignore"},
        plugin = {"pretty",
                "json:target/cucumber-results/DependentGroupA.json",
                "rerun:target/cucumber-results/Failed_DependentGroup1.txt"})
public class DependentGroupA extends ExtendedAbstractTestNGCucumberTests {
}