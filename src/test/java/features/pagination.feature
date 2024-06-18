Feature: Pagination allows user move trough friend list

  Scenario Outline: Looking at pagination when there is just one page of results
    Given The user is located at "https://friender.vercel.app/" home page
    When The user clicks on login button at Home's navbar
    And The login form is shown
    And The user enters the email "<email>" at email's field
    And The user enters the password "<password>" at password's field
    And The user clicks on login button in the form
    And The user is redirected to Buscar Amigos section
    And There is just one pagination number
    Then The navigation buttons are disabled

    Examples:
      | email                      | username                 | password       |
      | 202000229@est.umss.edu     | Emily Callejas           | 123Emi@@               |
      | jairotrabaja123@gmail.com  | Jairo Andree Maida Rojas | Contraseña123@ |
      | cetapigleisia@gmail.com    | Giulianno Morales Pinto  | vivaBolivia14$ |
      | j.airotrabaja123@gmail.com | JuanitoPoderoso          | Contraseña123@ |