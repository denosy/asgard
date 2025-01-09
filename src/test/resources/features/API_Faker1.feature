Feature: Faker API request

  @ApiFaker1
  Scenario: Sending API request _quantity #  - books

    Given : I`m sending request with Query Parameter "_quantity" with value "1"
    And   : I should verify status code is "200"
    And   : I should verify header Content-Type is equal to "application/json"
    Then  : I Should get status in body response "OK"
    And   : I Should get seed null
    Then  : I should see title in response body is not empty

