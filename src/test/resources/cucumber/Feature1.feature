@TestFeature1
Feature: Test Feature 1 for parallel purpose

  Background:
    Given BackGround step sleep "5" sec

  @DependentGroup1
  Scenario: Test Scenario 1 in TestFeature 1
    Given Step with sleep "5" sec in Scenario "1" of TestFeature "1"
    When Must be failed

  Scenario Outline: Test Scenario 2 in TestFeature 1
    Given Step with sleep "<sleep_sec>" sec in Scenario "<scenario_number>" of TestFeature "<feature_number>"
    Examples:
      | sleep_sec | scenario_number | feature_number |
      | 5         | 2               | 1              |

  Scenario Outline: Test Scenario 33 in TestFeature 1
    Given Step with sleep "<sleep_sec>" sec in Scenario "<scenario_number>" of TestFeature "<feature_number>"
    Examples:
      | sleep_sec | scenario_number | feature_number |
      | 5         | 33              | 1              |

  @DependentGroup2
  Scenario: Test Scenario 100 in TestFeature 1
    Given Step with sleep "5" sec in Scenario "100" of TestFeature "1"
