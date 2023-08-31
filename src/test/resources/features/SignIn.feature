@Smoke
Feature: Login

Background:
	Given User is on retail website homepage
	When User click on the login link

@login
Scenario: Verify user is able to login to tek retail website
	And User enter email 'nchurrican@gmail.com' and password 'Nchurrican911$'
	And User click on login button
	Then Verify user is logged in
	
  @createAccount
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name | email | password     | confirmPassword |
      | Hurican | Storme | IcanNotGiveYou$4It | IcanNotGiveYou$4It    |
    And User click on SignUp button
    Then User should be logged into account page