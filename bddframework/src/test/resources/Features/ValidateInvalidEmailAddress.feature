@tag
Feature: Invalid Email Address

  @TEST1
  Scenario: verify that invalid Email Address
    Given I click Login
    And I enter username as supp.pawar2110
    Then I verify that invalid Email address error message shown to user
