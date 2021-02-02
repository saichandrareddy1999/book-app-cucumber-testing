Feature: Dashboard, user redirecting to Dashboard after login with valid credentials
  
Scenario: Adding to Favourite
Given User redirects to login page 
And user able to see the information displayed about matches
When user click add to favorite button it should add to favorite
Then user should see the promt message as added successfully

  
Scenario: Adding to Recommendation
Given User redirects to login page 
And user able to see the information displayed about matches
When user click add to recommendation button it should add to recommendation
Then user should see the promt message as added successfully
    