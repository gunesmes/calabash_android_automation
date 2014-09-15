Feature: Login feature

   Background: User should open the application
    Given I go to login page

	  Scenario: As a user I can see login page
	    Then I should see login page

	  @t  
	  Scenario: As a in-valid user I can see error message
	    When I enter username as "mesut"
	    And I enter password as "mesut"
	    And I press "login" button
	    Then I should see error message

	  Scenario: As a valid user I can see page
	    When I enter username as "mesut"
	    And I enter password as "12345"
	    And I press "login" button
	    Then I should see home page

	  