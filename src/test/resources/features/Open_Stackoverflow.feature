@test
Feature: Open website
  It would be nice to open Stackoverflow website

  Scenario: Open Stackoverflow
    Given User "John Wick" is created
    Then I should be taken to "https://stackoverflow.com/"