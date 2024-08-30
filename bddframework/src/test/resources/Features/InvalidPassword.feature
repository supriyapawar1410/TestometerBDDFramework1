Feature: Invalid Password

 
  Scenario: verify that invalid Password
    Given I click Login
    And I enter username as supp.pawar2110@gmail.com
    And I enter password as Welcome@1234
    And I click on login button
    Then I verify that invalid password error message shown to user
