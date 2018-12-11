package com.epam.products.tests;

import com.epam.framework.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

/**
 * #Summary:
 * #Author: Andrii_Marchenko1
 * #Author’s Email:
 * #Creation Date: 7/19/2018
 * #Comments:
 */
public class MyStepsDef {
    private static final boolean MAKE_STEP_FAIL = true;
    private static final int BACKGROUND_SLEEP = 0;
    private static final int STEP_SLEEP = 1;

    private void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("^Background step with sleep$")
    public void backgroundStep() {
        Log.info(String.format("This is Background step with sleep '%s' seconds", BACKGROUND_SLEEP));
        sleep(BACKGROUND_SLEEP);

    }

    @Given("^Step with sleep$")
    public void stepNumberInScenarioOfTestFeature() {
        Log.info("=====================================================");
        Log.info(String.format("The step with '%s' sec sleep.", STEP_SLEEP));
        Log.info("=====================================================");
        sleep(STEP_SLEEP);
    }

    @Then("^Must be failed$")
    public void mustBeFailed() {
        Assert.assertFalse(MAKE_STEP_FAIL, "FAILED scenario.");
    }
}
