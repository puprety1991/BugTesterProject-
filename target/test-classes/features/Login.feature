Feature: Login functionality
  @Smoke
  Scenario: Valid Credential

    Given navigate to HRMS interface
    When user enters the valid username and password
    And user clicks on login button
    Then user successfully logged in

