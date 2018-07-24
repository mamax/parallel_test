package com.epam.products.tests;

import com.epam.framework.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * #Summary:
 * #Author: Andrii_Marchenko1
 * #Author’s Email:
 * #Creation Date: 7/19/2018
 * #Comments:
 */
public class MyStepsDef {
    private void sleep(int sec) {
        try {
            Thread.sleep(sec * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("^BackGround step sleep \"([^\"]*)\" sec$")
    public void backgroundStep(int sec) {
        Log.info(String.format("This is BackGround step with sleep '%s' seconds", sec));
        sleep(sec);

    }

    @Given("^Step with sleep \"([^\"]*)\" sec in Scenario \"([^\"]*)\" of TestFeature \"([^\"]*)\"$")
    public void stepNumberInScenarioOfTestFeature(int sec, String scenarioNumber, String featureNumber) {
        Log.info("=====================================================");
        Log.info(String.format("The step with sleep '%s' sec", sec));
        Log.info(String.format("The scenario number is '%s'", scenarioNumber));
        Log.info(String.format("The feature number is '%s'", featureNumber));
        Log.info("=====================================================");
        sleep(sec);
    }

    @When("^Must be failed$")
    public void mustBeFailed()   {
        Assert.fail("FAILED scenario.");
    }
}
