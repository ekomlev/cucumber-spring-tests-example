@test
Feature: Open websites
  It would be nice to open Github and then Google websites

  Scenario Outline: Open Github and Google
    Given User "John Wick" is created
    Then I should be taken to "<url>"

    Examples:
      | url                        |
      | https://github.com/ |
      | https://google.com/         |