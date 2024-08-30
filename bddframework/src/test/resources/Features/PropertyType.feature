

Feature: Browse By Property Types
  

  @tag1
  Scenario: Verify that user is able to see browse by property values
  
    Given I am on the landing page
    And I close the popup when I see it
    Then I see Browse By Property Types Hotels
    Then I see Browse By Property Types Apartments
    Then I see Browse By Property Types Resorts
    Then I see Browse By Property Types Villas
   
   @tag2 
  Scenario Outline: Verify that user is able to see browse by property values
  
    Given I am on the landing page
    And I close the popup when I see it
    Then I see Browse By Property Types <propertyName>
    
    Examples:
    
    |propertyName|
    |Hotels|
    |Apartments|
    |Resorts|
    |Villas|
 