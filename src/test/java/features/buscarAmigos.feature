Feature: The user can look for friends to rent at "Buscar Amigos" section

 Scenario Outline: A user who enabled his friend account can not find himself at the list of friends
    Given The friend user is at "https://friender.vercel.app/"
    When The user pushes the "Iniciar Sesión" button at navbar
    And Introduces "<email>" at user/email field
    And Introduces "<password>" at password field
    And Pushes "Iniciar Sesión" button
    Then The "Buscar Amigos" section is shown
    Then The user looks for "<username>" name on every list result and doesn't find anything

    Examples:
      | email                     | username                 | password       |
      | jairotrabaja123@gmail.com | Jairo Andree Maida Rojas | Contraseña123@ |
      | cetapigleisia@gmail.com   | Giulianno Morales Pinto  | vivaBolivia14$ |

