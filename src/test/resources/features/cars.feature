Feature: Cucumber Data Tables cars

  @cars
  Scenario: User should be able to see all 7 cars
    Given User is on the dropDowns page
    Then  user should see below info in cars dropDown
      | Volvo      |
      | BMW        |
      | Opel       |
      | Audi       |
      | Toyota     |
      | Renault    |
      | Maruti Car |


