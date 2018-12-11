@TestFeature5
Feature: Test Feature 5 for parallel purpose

  Background:
    Given Background step with sleep

  Scenario: Test Scenario 1 in TestFeature 5
    Given Step with sleep

  @DependentGroupB
  Scenario: Test Scenario 2 in TestFeature 5
    Given Step with sleep
    Then Must be failed

  Scenario: Test Scenario 3 in TestFeature 5
    Given Step with sleep

  Scenario: Test Scenario 4 in TestFeature 5
    Given Step with sleep