Feature: Login feature

   Background: User should open the application
    Given I open the application

	  Scenario: As a user I can see login page
	    Then I should see "login" page

	  Scenario: As a in-valid user I can see error message
	    When I enter "username" text field as "mesut-test"
	    And I enter "password" text field as "mesut"
	    And I press "login" button
	    Then I should see message as "Username or Password is incorrect!"

	  Scenario: As a valid user I can see page
	    When I enter "username" text field as "mesut-test"
	    And I enter "password" text field as "12345"
	    And I press "login" button
	    Then I should see "home page"  