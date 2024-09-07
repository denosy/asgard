Feature: Users should be able to login
  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: driver, sales manager, store manager


  Scenario Outline: Login with
    Given user is on the login page
    When the user login with given credentials from "<SheetName>" and <RowNumber>
    Then the user should be able to log in and see their name

    Examples:
      | SheetName    | RowNumber |
      | VytrackUsers | 1         |
      | VytrackUsers | 2         |
      | VytrackUsers | 3         |
      | VytrackUsers | 4         |
      | VytrackUsers | 5         |
      | VytrackUsers | 6         |


