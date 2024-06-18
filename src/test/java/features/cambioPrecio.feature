Feature: Verificar la actualización del precio al cambiarlo y pulsar 'Cambiar precio'

Cuando un usuario inicie sesion en modo Amigo y decida cambiar el precio de su alquiler, 
el sistema debe facilitar la modificación del precio y asegurarse de que el cambio se refleje de manera precisa 
en el perfil de este amigo.

 Scenario Outline: User who enables his friend account and changes the price of his rental
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
      | email                        | password       | new_price |
      | zapataparidaniela@gmail.com  | nuevaContra24- | 45        |
