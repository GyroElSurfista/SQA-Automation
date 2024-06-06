Feature: Friend users can check their pending requests at their requests tray

  Scenario Outline: A User who doesn't have pending requests visualizes a message telling so in the requests tray
    Given The user is located at "https://friender.vercel.app/" home page
    When The user clicks on login button at Home's navbar
    And The login form is shown
    And The user enters the email "<email>" at email's field
    And The user enters the password "<password>" at password's field
    And The user clicks on login button in the form
    And The user is redirected to Buscar Amigos section
    And The user clicks on the profile button at navbar
    And The user is redirected to his profile
    And The user clicks on Solicitudes Pendientes Button
    Then The user is redirected to his requests tray and the message "No hay solicitudes pendientes" is shown

    Examples:
      | email                      | username                 | password       |
      | jairotrabaja123@gmail.com  | Jairo Andree Maida Rojas | Contraseña123@ |
      | cetapigleisia@gmail.com    | Giulianno Morales Pinto  | vivaBolivia14$ |
      | j.airotrabaja123@gmail.com | JuanitoPoderoso          | Contraseña123@ |


