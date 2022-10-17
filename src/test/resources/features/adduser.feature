Feature: Add user into cms and create user in cms
@adduser
Scenario: Check add user page
Given Click on manage
And Verify people button is dipslayed and click it
And Click on Add user button
Then Verify Add user page is displayed

  @createuser @deleteuser
  Scenario: Create user in cms
    Given Check Add user page
    And check on Admin checkbox under Roles
    And Enter all required fields
    Then Click on create new account

