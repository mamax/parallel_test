package com.epam.framework;

import cucumber.api.Scenario;
import org.apache.commons.lang3.StringUtils;

public class BaseHooks {
    public String getScenarioName(Scenario scenario) {
        return scenario.getName() + (isScenarioOutline(scenario) ? getScenarioOutlineExampleNumber(scenario) : "");
    }

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

    private boolean isScenarioOutline(Scenario scenario) {
        return scenario.getId().split(";").length > 2;
    }

    private String getScenarioOutlineExampleNumber(Scenario scenario) {
        int number = Integer.parseInt(scenario.getId().split(";")[3]) - 1;
        return String.format("(Example %s)", number);
    }
}
