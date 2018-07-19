package com.epam.framework.context;

/**
 * #Summary:
 * #Author: Andrii_Marchenko1
 * #Author’s Email:
 * #Creation Date: 2/23/2018
 * #Comments:
 */
public class ContextFI {
    private ContextFI() {
    }

    private static String scenarioName;

    public static String getScenarioName() {
        return scenarioName;
    }

    public static void setScenarioName(String scenarioName) {
        ContextFI.scenarioName = scenarioName;
    }
}
