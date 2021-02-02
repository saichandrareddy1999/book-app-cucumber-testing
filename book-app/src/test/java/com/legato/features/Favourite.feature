Feature: Faviourite page, User gets redirected to favourie page

Scenario: displaying the faviourite list iteams 
Given User has to redirects to login page
When user click add to favorite button in the home page
And user click on favourite
Then should display the list of favourite 

 Scenario: displaying the pro
Given User has to redirects to login page
When user click add to favorite button in home page
And user should see error message
Then should display the list of favourite 
  