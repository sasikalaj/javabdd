Feature: Homepage search filters 

   As an user 
   I should be able to search for properties in the Homepage with advanced filters 
   So that I can find a properties easily 

  Background
    Given I am already in Homepage

  @solo
  Scenario: Basic channels in the Homepage
     Then I see for sale channel tab on the homepage
     When I enter London in the location field
      And I hit the search button
     Then Url should contain /for-sale/property/london
