@TestFeature1
Feature: Test Feature 1 for parallel purpose

  Background:
    Given Background step with sleep

  @DependentGroupA
  Scenario: Test Scenario 1 in TestFeature 1
    Given Step with sleep
    Then Must be failed

  Scenario: Test Scenario 2 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 3 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 4 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 5 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 6 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 7 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 8 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 9 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 10 in TestFeature 1
    Given Step with sleep

  @DependentGroupB
  Scenario: Test Scenario 11 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 12 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 13 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 14 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 15 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 16 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 17 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 18 in TestFeature 1
    Given Step with sleep

  @DependentGroupA
  Scenario: Test Scenario 19 in TestFeature 1
    Given Step with sleep

  Scenario: Test Scenario 20 in TestFeature 1
    Given Step with sleep
