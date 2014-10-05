Feature: Sign-up feature
   As An anonymous user
   I Want to be member of the application
   So That I can register with sign-up form

   Background: User should open the sign-up form
    Given I open the application
    And I go to "sign-up" page

	  Scenario: As a user I can see login page
	    Then I should see "Sign-up" page
 
	  Scenario: User should see form validation message for empty fields
	  	When I press "sign-up" button
	  	Then I should see message as "Please fill the form"

	  Scenario: User should see form validation message for empty password
	  	When I enter "username" text field as "Mesut"
	  	When I press "sign-up" button
	  	Then I should see message as "Please fill the form"

	  Scenario: User should see form validation message for empty re-password
	  	When I enter "username" text field as "Mesut"
	  	When I enter "password" text field as "Mesut"
	  	When I press "sign-up" button
	  	Then I should see message as "Please fill the form"

	  @t	
	  Scenario: User should see succesfull registion message
	  	When I enter "username" text field as "Mesut"
	  	When I enter "password" text field as "Mesut"
	  	When I enter "re-type password" text field as "Mesut"
	  	When I press "sign-up" button
	  	Then I should see message as "User is registered. Click login button for login page"

	  Scenario: User should see username dublication error
	  	When I enter "username" text field as "Mesut"
	  	When I enter "password" text field as "Mesut"
	  	When I enter "re-type password" text field as "Mesut"
	  	When I press "sign-up" button
	  	Then I should see message as "User is exists, change user name"
