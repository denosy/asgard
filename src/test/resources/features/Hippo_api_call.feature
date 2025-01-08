Feature: api call

  @Api
  Scenario: User should get the response form API call

    Given : User is on the zippoptam Page and User sending zip code "90210"
    And : Accept header is "application/json"
    And : User should see in response state - "California"
    Then : status code should be 200
