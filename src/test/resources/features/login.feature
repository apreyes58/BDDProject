#Give Title.
Feature: Testing login functionality
  #Write out the scenario for the feature that is being tested.
  @smoketest
  Scenario: Check login is successful with valid credentials
    #Now create the steps of the feature
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page



#  #Scenario outline can have examples (parameters)
#  Scenario Outline: Check login is successful with valid credentials
#    Given user is on login page
#
#    When user enters <username> and <password>
#    And clicks on login button
#    Then user is navigated to the home page
#
#    Examples:
#      | username | password |
#      | user1    | pass1    |
#      | user2    | pass2    |