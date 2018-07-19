package com.epam.framework;

import cucumber.api.Scenario;
import org.apache.commons.lang3.StringUtils;

public class BaseHooks {

    public void printScenarioName(Scenario scenario) {
        int length = ("===SCENARIO: " + scenario.getName() + "===").length();
        Log.info(StringUtils.repeat("=", length));
        Log.info(String.format("===SCENARIO: %s===", scenario.getName()));
        Log.info(StringUtils.repeat("=", length));
    }

    public void printVerdict(Scenario scenario) {
        String verdict = scenario.getStatus().toUpperCase();
        String line = String.format("===SCENARIO %s: " + scenario.getName() + "===", verdict);
        int length = line.length();
        Log.info(StringUtils.repeat("=", length));
        Log.info(line);
        Log.info(StringUtils.repeat("=", length) + "\n");
    }
}
