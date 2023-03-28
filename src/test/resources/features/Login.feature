Feature: Login functionality
  @Smoke
  Scenario: Valid Credential

    When user enters the valid username and password
    And user clicks on login button
    Then user successfully logged in


