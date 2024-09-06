Feature: Wikipedia login presentation, as a user, I want to search for a specific data and data has tp match
  with the title

Given user is on the login page of the library application


  Scenario:
    Given User logged as a wikipedia authorized user
    When User enters "Steve Jobs" in the search box
    Then User clicks wikipedia search button
    And User has to see "Steve Jobs" is in the image header
    And User has to see "Steve Jobs" is in the wiki title
    And User has to see "Steve Jobs" is in the main header




  Scenario Outline:
    Given User logged as a wikipedia authorized user
    When User enters "<searchValue>" in the search box
    Then User clicks wikipedia search button
    And User has to see "<expectedImageHeader>" is in the image header
    And User has to see "<expectedTitle>" is in the wiki title
    And User has to see "<expectedMainHeader>" is in the main header


    Examples: search vales we are going to be using in this scenarios outline
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs          |
      | Rosalind Brewer | Rosalind Brewer | Rosalind Brewer    | Rosalind Brewer     |
      | Sundar Pichai   | Sundar Pichai   | Sundar Pichai      | Sundar Pichai       |
      | Marie Curie     | Marie Curie     | Marie Curie        | Marie Curie         |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein     |

