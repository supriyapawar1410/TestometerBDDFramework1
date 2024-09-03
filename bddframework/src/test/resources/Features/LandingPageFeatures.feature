
Feature: Verify landing Page Features

@Regression
   Scenario: Verify that main features is the site are displayed to the user
   
    Given I am on the landing page
    And I close the popup when I see it
    Then I see the features called Stays
    Then I see the features called Flights
    Then I see the features called Flights+Hotel
    Then I see the features called Car rentals
    Then I see the features called Attractions
    Then I see the features called Airport taxis
    
    @Sanity
    Scenario Outline: Verify that main features is the site are displayed to the user
    Given I am on the landing page
    And I close the popup when I see it
    Then I see the features called <featureName>
    
    Examples:
    |featureName|
    |Stays|
    |Flights|
    |Flights+Hotel|
    |Car rentals|
    |Attractions|
    |Airport taxis|
    