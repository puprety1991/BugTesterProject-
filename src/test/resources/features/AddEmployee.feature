Feature: Adding Employee modules
  Background:
    When user enters the valid username and password
    And user clicks on login button
@test1
    Scenario: Add Employee
      When user clicks on the PIM option
      And user clisks Add Employee option
      And user provide employee information from excel with sheetName "EmpInfo"
      And user clicks the Add button
      Then user verifies the data
