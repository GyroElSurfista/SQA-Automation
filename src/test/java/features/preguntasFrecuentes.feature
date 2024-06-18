Feature: Verify redirection when pressing "Leer más..." in Frequently Asked Questions

  Scenario Outline: Pressing "Leer más..." redirects to a construction page
    Given The client user is at "https://friender.vercel.app/"
    When The user pushes the "Iniciar Sesión" button at navbar
    And The user logs in with the credentials "<email>" and "<password>"
    And The user clicks on the "Home" tab in the navbar
    And The user scrolls down to the "Preguntas Frecuentes" section
    And The user presses the "Leer más..." button below the description of the section
    Then The user is redirected to a construction page

    Examples:
      | email                     | password       |
      | jairotrabaja123@gmail.com | Contraseña123@ |

