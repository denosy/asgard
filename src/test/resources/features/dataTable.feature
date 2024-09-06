Feature: Cucumber Data Tables

  Scenario: List of fruits and vegetables I like
    Then  user should see below list
      | orange     |
      | apple      |
      | kiwi       |
      | strawberry |
      | tomato     |
      | pear       |
      | eggplant   |


  Scenario: Avengers member
    Then  user should see any data he wants
      | name     | Tony         |
      | lastName | Stark        |
      | age      | 41           |
      | address  | marvel       |
      | state    | NY           |
      | zipcode  | 12621        |
      | phone    | 111-111-1111 |


  @dataTable
  Scenario: User should be able to see all 12 month in months
    Given User is on the dropDowns page
    Then  user should see below info in month dropDown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |




