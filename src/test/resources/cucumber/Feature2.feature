@TestFeature1
Feature: Test Feature 1 for parallel purpose

  Background:
    Given BackGround step sleep "5" sec

  Scenario Outline: Test Scenario 1 in TestFeature 2
    Given Step with sleep "<sleep_sec>" sec in Scenario "<scenario_number>" of TestFeature "<feature_number>"
    Examples:
      | sleep_sec | scenario_number | feature_number |
      | 5         | 1               | 2              |
      | 5         | 1               | 2              |
      | 5         | 1               | 2              |
      | 5         | 1               | 2              |

  Scenario Outline: Test Scenario 2 in TestFeature 2
    Given Step with sleep "<sleep_sec>" sec in Scenario "<scenario_number>" of TestFeature "<feature_number>"
    Examples:
      | sleep_sec | scenario_number | feature_number |
      | 5         | 2               | 2              |
      | 5         | 2               | 2              |
      | 5         | 2               | 2              |
      | 5         | 2               | 2              |

  @SynchronizedGroup1
  Scenario Outline: Test Scenario 33 in TestFeature 2
    Given Step with sleep "<sleep_sec>" sec in Scenario "<scenario_number>" of TestFeature "<feature_number>"
    Examples:
      | sleep_sec | scenario_number | feature_number |
      | 5         | 33              | 2              |
      | 5         | 33              | 2              |
      | 5         | 33              | 2              |
      | 5         | 33              | 2              |
