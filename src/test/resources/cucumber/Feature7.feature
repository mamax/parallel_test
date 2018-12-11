@TestFeature7
Feature: Test Feature 7 for parallel purpose

  Background:
    Given Background step with sleep

  @DependentGroupA
  Scenario: Test Scenario 1 in TestFeature 7
    Given Step with sleep

  Scenario: Test Scenario 2 in TestFeature 7
    Given Step with sleep

  Scenario: Test Scenario 3 in TestFeature 7
    Given Step with sleep

  Scenario: Test Scenario 4 in TestFeature 7
    Given Step with sleep

  Scenario: Test Scenario 5 in TestFeature 7
    Given Step with sleep

  Scenario: Test Scenario 6 in TestFeature 7
    Given Step with sleep

  Scenario: Test Scenario 7 in TestFeature 7
    Given Step with sleep

  @DependentGroupB
  Scenario: Test Scenario 8 in TestFeature 7
    Given Step with sleep
    Then Must be failed