@TestFeature2
Feature: Test Feature 2 for parallel purpose

  Background:
    Given Background step with sleep

  Scenario: Test Scenario 1 in TestFeature 2
    Given Step with sleep

  Scenario: Test Scenario 2 in TestFeature 2
    Given Step with sleep

  Scenario: Test Scenario 3 in TestFeature 2
    Given Step with sleep

  Scenario: Test Scenario 4 in TestFeature 2
    Given Step with sleep

  Scenario: Test Scenario 5 in TestFeature 2
    Given Step with sleep
    Then Must be failed
