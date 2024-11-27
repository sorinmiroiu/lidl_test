Feature: Login functionality

  Scenario: Valid user login
    Given the user is on the login page
    When the user clicks the login button
    When the user enters valid credentials
    Then the user should be redirected to the dashboard
