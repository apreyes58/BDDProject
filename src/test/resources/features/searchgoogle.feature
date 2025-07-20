Feature: feature to search up an important question

  Scenario: google search works

    Given browser is opened
    And user is on google search page
    When user enters a text in search box
    And enters the search
    Then user navigates the search result