package com.epam.products.tests;

import com.epam.framework.BaseHooks;
import com.epam.framework.context.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before(order = 10)
    public void printScenarioName(Scenario scenario) {
        ContextFI.setScenarioName(scenario.getName());
        new BaseHooks().printScenarioName(scenario);
    }

    @After(order = 5)
    public void verdict(Scenario scenario) {
        new BaseHooks().printVerdict(scenario);
    }
}
