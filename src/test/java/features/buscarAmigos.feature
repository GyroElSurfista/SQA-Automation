Feature: The user can look for friends to rent at "Buscar Amigos" section

  Scenario: A user who enabled his friend account can not find himself at the list of friends
    Given The friend user is at "https://friender.vercel.app/"
    When The user pushes the "Iniciar Sesión" button at navbar
    And Introduces "jairotrabaja123@gmail.com" at user/email field
    And Introduces "Contraseña123@" at password field
    And Pushes "Iniciar Sesión" button
    Then The "Buscar Amigos" section is shown
   # Then The user looks for "Jairo Andree Maida Rojas" name on every list result and doesn't find anything
