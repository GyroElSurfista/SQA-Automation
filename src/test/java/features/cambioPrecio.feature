Feature: The user can look for friends to rent at "Cambiar Precio" section

 Scenario Outline: A user who enabled his friend account can not find himself at the list of friends
    Given The friend user is at "https://friender.vercel.app/"
    When The user pushes the "Iniciar Sesión" button at navbar
    And Introduces "<email>" at user/email field
    And Introduces "<password>" at password field
    And Pushes "Iniciar Sesión" button
    Then The user is redirected to Mi Perfil section
    And The user pushes the "Cuenta de Amigo" button at sidebar
    When The user changes the price to "<new_price>"
    And The user pushes the "Cambiar Precio" button
    And The user pushes the "Mi Perfil" button at profile sidebar
   
    Examples:
      | email                       | username            | password       | new_price |
      | zapataparidaniela@gmail.com | Daniela Zapata Pari | nuevaContra24- | 100       |
