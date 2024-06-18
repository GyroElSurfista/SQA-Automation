Feature: A user can see the calculation of the cost of a meeting

  Scenario: A logged in user can check the calculation of the cost of a meeting in the rental application form
    Given The client user is at "https://friender.vercel.app/"
    When The user pushes the "Iniciar Sesión" button at navbar
    And The user logs in with the credentials "<email>" and "<password>"
    And The user selects a friend from the list in "Buscar Amigos" section
    And The user enters a "<duration>" of the meeting in the rental application form
    Then The system calculates and shows the total cost of the meeting

    Examples:
      | email                     | password       | duration |
      | jairotrabaja123@gmail.com | Contraseña123@ | 3        |
