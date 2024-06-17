Feature: Pagination allows user move trough friend list

  Scenario: Looking at pagination when there is just one page of results
    Given The user is located at "https://friender.vercel.app/" home page
    When The user clicks on login button at Home's navbar
    And The login form is shown
    And The user enters the email "202000229@est.umss.edu" at email's field
    And The user enters the password "123Emi@@" at password's field
    And The user clicks on login button in the form
    And The user is redirected to Buscar Amigos section
    And There is just one pagination number
    Then The navigation buttons are disabled
