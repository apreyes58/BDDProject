Feature: Testing login functionality

  Scenario: Check login is successful when credentials are valid

    Given user has browser opened
    And user goes on the login page
    When user enters their username and password
    And user presses enter or clicked login
    Then user is brought to the home page