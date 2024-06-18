# author: Winsor Orellana
# date: 01/05/2024
# language: es

Requisito: Verificar que un código aleatorio no sea validado en el registro de un usuario

  Este test case verifica que los códigos de registro aleatorios
  no sean validados o utilizables para el registro de un usuario

  Escenario: Registrar usuario cliente

  Esquema del escenario: Un usuario cliente registrándose en la aplicación web
    Dado Un usuario cliente registrándose en "https://friender.vercel.app/registrar"
    Cuando Llena parcialmente el formulario con los datos "<Nombre>", "<Apellido paterno>", "<Apellido materno>", "<Fecha de nacimiento>", "<Genero>", "<Ubicacion>", "<Nombre de usuario>", "<Correo>", "<Password>"
    Y Pulsa el botón 'Siguiente'
    Y Ingresa un "<Codigo>" aleatorio
    Entonces Visualiza un mensaje de error
    Ejemplos:
      | Nombre | Apellido paterno | Apellido materno | Fecha de nacimiento | Genero | Codigo | Ubicacion  | Nombre de usuario | Correo                 | Password  |
      | Winsor | Orellana         | Vásquez          | 30012002            | M      | JHKEO  | Cochabamba | Winsor2002        | winsoromar12@gmail.com | Pepit@123 |