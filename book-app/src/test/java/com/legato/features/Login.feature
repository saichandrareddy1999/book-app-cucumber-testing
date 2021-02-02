Feature: Login page, User trying to login with valid and invalid credentials

Scenario: User Login with the valid
Given user gets redirect to the login page
When User enter the username and password
And Click the submit button in the page
Then user has to login successfully
And User redirect to home page

Scenario: Users can login in the login page with username and password
Given user gets redirect to the login page
When User enter the username as aa@gmail.com and password as aa123 in the field
And Click the submit button in the page
Then user has to login successfully
And User redirect to home page


