Feature: 
  In Order to manage portal user should be able to create a account by using name, email, password and confirm password in Register page

  Scenario: User able to Add the details successfully
    Given User gets redirtect to the singUp page
    When User has to give fname, lname, Email, password and Confirm password
    And Click the submit button
    Then User should see the successfully added promt message

  Scenario: User able to Add the details successfully in the register
    Given User gets redirtect to the singUp page
    When User enter the fname as john lname as john Email as john@gmail.com password as john and Confirm password as john in the fields
    And Click the submit button
    Then User should see the successfully added promt message

  #Scenario Outline: 
    #Given User gets redirtect to the singUp page
    #When User has to gives <fname>, <lname>, <Email>, <password> and <Confirm password>
    #And Click the submit button
    #Then User should see the successfully added promt message

    
