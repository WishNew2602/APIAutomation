@current
Feature: OpenWeather Current Weather Data API

  Scenario Outline: OpenWeather Current Weather Data API
    Given I have built GET request
    And I have provided <City> and <Country> as Query params and API Key
    When I Get Response from API
    Then I verify the <City> in Response

    Examples: 
      | City      | Country |
      | Hyderabad | India   |
      | London    | UK      |