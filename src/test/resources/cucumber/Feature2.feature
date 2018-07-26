@TestFeature2
Feature: Test Feature 2 for parallel purpose

  Background:
    Given BackGround step sleep "5" sec

  @DependentGroup2
  Scenario: Test Scenario 1 in TestFeature 2
    Given Step with sleep "5" sec in Scenario "1" of TestFeature "1"

  Scenario Outline: Test Scenario 2 in TestFeature 2
    Given Step with sleep "<sleep_sec>" sec in Scenario "<scenario_number>" of TestFeature "<feature_number>"
    When Must be failed
    Examples:
      | sleep_sec | scenario_number | feature_number |
      | 5         | 2               | 2              |

  @DependentGroup1
  Scenario: Test Scenario 15 in TestFeature 2
    Given Step with sleep "5" sec in Scenario "15" of TestFeature "2"

  Scenario Outline: Test Scenario 25 in TestFeature 2
    Given Step with sleep "<sleep_sec>" sec in Scenario "<scenario_number>" of TestFeature "<feature_number>"
    Examples:
      | sleep_sec | scenario_number | feature_number |
      | 5         | 25              | 2              |
