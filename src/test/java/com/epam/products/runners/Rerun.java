package com.epam.products.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"@target/cucumber-results/rerun_failed_scenarios.txt"},
        glue = "com.epam.products.tests",
        plugin = {"pretty",
                "json:target/cucumber-results/rerun.json"})
public class Rerun extends AbstractTestNGCucumberTests {
}