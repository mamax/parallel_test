@LookupAccountNumberDialog
Feature: Lookup Account Number dialog
  In order to regression testing of Lookup Account Number dialog feature
  As a Support Personnel (SP)
  I want to have an ability verify components (filters, sorting of table) and modules on Lookup Account Number dialog

  Background:
    Given I open Landing page of Fleet Insight portal
    When I am signing in with "company.17305.pesa" login and password, select country "United States" and check Don't Show this Message Again

  Scenario Outline: [FI-677] Check Close button (Account Number Lookup)
    Given I invoke Fleet Insight "<module>" page through "landing_page"
    Then I check the page "<module>" of Fleet Insight product is "invoked"
    When I invoke Fleet Insight "Unit Maintenance" page through Your Fleet button using "<unit_number>"
    And I click header button "REQUEST SERVICE" on page "Unit Maintenance" of Fleet Insight product
    Then I check the page "Request Service" of Fleet Insight product is "invoked"
    Then I check the footer button "Submit Service Request" on "Request Service" action page is "disabled"
    When I select tab "<tab_name>" of Vehicle Details on Request Service page
    Then I check the selected tab of Vehicle Details is "<tab_name>" on Request Service page
    And I invoke Lookup an Account Number modal dialog from Request Service page
    And I close modal dialog of Fleet Insight portal
    Then I check the modal dialog "Lookup an Account Number" of Fleet Insight product is "disappeared"
    Examples:
      | module      | unit_number | tab_name              |
      | Maintenance | 112852      | Non-contract vehicles |

  Scenario Outline: [FI-678] Check Cancel button (Account Number Lookup)
    Given I invoke Fleet Insight "<module>" page through "landing_page"
    Then I check the page "<module>" of Fleet Insight product is "invoked"
    When I invoke Fleet Insight "Unit Maintenance" page through Your Fleet button using "<unit_number>"
    And I click header button "REQUEST SERVICE" on page "Unit Maintenance" of Fleet Insight product
    Then I check the page "Request Service" of Fleet Insight product is "invoked"
    Then I check the footer button "Submit Service Request" on "Request Service" action page is "disabled"
    When I select tab "<tab_name>" of Vehicle Details on Request Service page
    Then I check the selected tab of Vehicle Details is "<tab_name>" on Request Service page
    And I invoke Lookup an Account Number modal dialog from Request Service page
    And I click on footer button "Cancel" on modal dialog of Fleet Insight portal
    Then I check the modal dialog "Lookup an Account Number" of Fleet Insight product is "disappeared"
    Examples:
      | module      | unit_number | tab_name              |
      | Maintenance | 112852      | Non-contract vehicles |

  @Smoke
  Scenario Outline: [FI-679] Check Search Input (Account Number Lookup)
    Given I invoke Fleet Insight "<module>" page through "landing_page"
    Then I check the page "<module>" of Fleet Insight product is "invoked"
    When I invoke Fleet Insight "Unit Maintenance" page through Your Fleet button using "<unit_number>"
    And I click header button "REQUEST SERVICE" on page "Unit Maintenance" of Fleet Insight product
    Then I check the page "Request Service" of Fleet Insight product is "invoked"
    Then I check the footer button "Submit Service Request" on "Request Service" action page is "disabled"
    When I select tab "<tab_name>" of Vehicle Details on Request Service page
    Then I check the selected tab of Vehicle Details is "<tab_name>" on Request Service page
    When I invoke Lookup an Account Number modal dialog from Request Service page
    Then I check the modal dialog "Lookup an Account Number" of Fleet Insight product is "appeared"
    Then I check the "placeholder" of Search account number textfield is "Search within your fleet"
    When I search Account Number "<search_pattern>" on Account Number modal dialog
    Then I check values of table column "ACCOUNT NUMBER" contain pattern "<search_pattern>" on "<dialog_identifier>" modal dialog
    Examples:
      | module      | unit_number | tab_name              | search_pattern | dialog_identifier        |
      | Maintenance | 112852      | Non-contract vehicles | HPTL-667082-01 | Lookup an Account Number |

  Scenario Outline: [FI-680] Check Filters button (Account Number Lookup)
    Given I invoke Fleet Insight "<module>" page through "landing_page"
    Then I check the page "<module>" of Fleet Insight product is "invoked"
    When I invoke Fleet Insight "Unit Maintenance" page through Your Fleet button using "<unit_number>"
    And I click header button "REQUEST SERVICE" on page "Unit Maintenance" of Fleet Insight product
    Then I check the page "Request Service" of Fleet Insight product is "invoked"
    Then I check the footer button "Submit Service Request" on "Request Service" action page is "disabled"
    When I select tab "<tab_name>" of Vehicle Details on Request Service page
    Then I check the selected tab of Vehicle Details is "<tab_name>" on Request Service page
    When I invoke Lookup an Account Number modal dialog from Request Service page
    Then I check the modal dialog "<dialog_identifier>" of Fleet Insight product is "appeared"
    Then I check Filters selection is "collapsed" on "<dialog_identifier>" modal dialog
    When I "invoke" Filters component on "<dialog_identifier>" modal dialog
    Then I check Filters selection is "expanded" on "<dialog_identifier>" modal dialog
    When I set filter checkbox "<filter_name>" to "checked" state on "<dialog_identifier>" modal dialog
    And I click Apply Filters button on "<dialog_identifier>" modal dialog
    And I "close" Filters component on "<dialog_identifier>" modal dialog
    Then I check the component of Applied Filter below is "appeared" and has applied filters on "<dialog_identifier>" modal dialog:
      | Customer name(1) |
    When I search Account Number "<search_pattern>" on Account Number modal dialog
    Then I check Filters button is disabled if table has 5 or fewer rows before filters were applied on "<dialog_identifier>" modal dialog
    Examples:
      | module      | unit_number | tab_name              | search_pattern      | dialog_identifier        | filter_name   |
      | Maintenance | 112852      | Non-contract vehicles | HPTL-667082-00-0019 | Lookup an Account Number | Customer Name |

  @Defect(s) @FI-1638
  Scenario Outline: [FI-681] Check sorting (Account Number Lookup)
    Given I invoke Fleet Insight "<module>" page through "landing_page"
    Then I check the page "<module>" of Fleet Insight product is "invoked"
    When I invoke Fleet Insight "Unit Maintenance" page through Your Fleet button using "<unit_number>"
    And I click header button "REQUEST SERVICE" on page "Unit Maintenance" of Fleet Insight product
    Then I check the page "Request Service" of Fleet Insight product is "invoked"
    Then I check the footer button "Submit Service Request" on "Request Service" action page is "disabled"
    When I select tab "<tab_name>" of Vehicle Details on Request Service page
    Then I check the selected tab of Vehicle Details is "<tab_name>" on Request Service page
    When I invoke Lookup an Account Number modal dialog from Request Service page
    Then I check the modal dialog "<dialog_identifier>" of Fleet Insight product is "appeared"
    When I save the display indicator of rows count on "<dialog_identifier>" modal dialog
    And I sort table by "<column_name1>" header in "ASC" order on "<dialog_identifier>" modal dialog
    Then I check the display indicator count of table on "<dialog_identifier>" page
    Then I check the sorting order is "ASC" for column "<column_name1>" on "<dialog_identifier>" modal dialog
    When I save the display indicator of rows count on "<dialog_identifier>" modal dialog
    And I sort table by "<column_name1>" header in "DESC" order on "<dialog_identifier>" modal dialog
    Then I check the display indicator count of table on "<dialog_identifier>" page
    Then I check the sorting order is "DESC" for column "<column_name1>" on "<dialog_identifier>" modal dialog
    When I save the display indicator of rows count on "<dialog_identifier>" modal dialog
    And I sort table by "<column_name2>" header in "ASC_ORACLE_DB" order on "<dialog_identifier>" modal dialog
    Then I check the display indicator count of table on "<dialog_identifier>" page
    Then I check the sorting order is "ASC_ORACLE_DB" for column "<column_name2>" on "<dialog_identifier>" modal dialog
    When I save the display indicator of rows count on "<dialog_identifier>" modal dialog
    And I sort table by "<column_name2>" header in "DESC_ORACLE_DB" order on "<dialog_identifier>" modal dialog
    Then I check the display indicator count of table on "<dialog_identifier>" page
    Then I check the sorting order is "DESC_ORACLE_DB" for column "<column_name2>" on "<dialog_identifier>" modal dialog
    Examples:
      | module      | unit_number | tab_name              | dialog_identifier        | column_name1  | column_name2    |
      | Maintenance | 112852      | Non-contract vehicles | Lookup an Account Number | CUSTOMER NAME | BILLING ADDRESS |


