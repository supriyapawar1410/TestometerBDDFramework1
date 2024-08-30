
@tag
Feature: Login Page Scenarios

@BDD
Scenario: Verify that the login is successful

    Given I click Login
    When I enter username as supp.pawar2110@gmail.com
    And I enter password as Welcome@1234
    And I click on login button
    Then I see Your account is displayed
    

  