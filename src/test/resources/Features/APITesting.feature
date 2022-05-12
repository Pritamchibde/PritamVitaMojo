Feature: Successful User Registration and Login Flow

  Scenario: Verify user registration
    Given I set POST registration service API endpoint
    When I set request headers
    And Send a POST request with user registration details
    Then I status code 201 should be received

  Scenario: Verify user is able to login
    Given I set POST Login service API endpoint
    When I set request headers
    And Send a POST request with login details
    Then I status code 201 should be received