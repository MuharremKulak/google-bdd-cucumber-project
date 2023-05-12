Feature: Search functionality on Google

  Scenario: Search for a term on Google
    Given I am on the Google search page
    When I search for "cucumber tutorial"
    Then search results for "cucumber tutorial" are displayed

