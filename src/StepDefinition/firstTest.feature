Feature: FirstTest
  As a user I should able to find gym.

  Scenario: I search by a particular postcode
    Given I navigate to home page
    When I enter a postcode "W2 1AJ"
    Then I see in results "Paddington"