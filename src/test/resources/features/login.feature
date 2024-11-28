Feature: Login functionality

  @PositiveLogin
  Scenario: Valid user login
    Given the user is on the main page
    When the user goes to login page
    And the user enters credentials
    Then the user should be redirected to the dashboard

  @NegativeLogin
  Scenario Outline: Invalid user login
    Given the user is on the main page
    When the user goes to login page
    And the user enters specific credentials <username> and <password>
    Then the user should not be redirected to the dashboard
    Examples:
      | username                | password        |
      | miroiu.sorin1@gmail.com | invalidPassword |
      | notAnEmail              | password        |



