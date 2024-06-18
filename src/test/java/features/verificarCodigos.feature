# author: Winsor Orellana
# date: 01/05/2024
# language: es

Requisito: Verificar que los códigos de registro no se envíen al correo electrónico de un usuario ya registrado en el sistema

  Este test case verifica que los códigos de registro solicitados durante el proceso
  de registro se envíen al correo electrónico del usuario

  Escenario: Registrar usuario cliente

  Esquema del escenario: Un usuario cliente registrándose en la aplicación web
    Dado Un usuario cliente registrándose en "https://friender.vercel.app/registrar"
    Cuando Llena parcialmente el formulario con los datos "<Nombre>", "<Apellido paterno>", "<Apellido materno>", "<Fecha de nacimiento>", "<Genero>", "<Ubicacion>", "<Nombre de usuario>", "<Correo>", "<Password>"
    Y Pulsa el botón 'Siguiente'
    Y Ingresa un "<Codigo>" aleatorio
    Entonces Recibe códigos de verificación en la bandeja de su "<Correo>" en "https://gmail.com/" usando su "<Password>"
    Ejemplos:
      | Nombre | Apellido paterno | Apellido materno | Fecha de nacimiento | Genero | Codigo | Ubicacion  | Nombre de usuario | Correo                 | Password  |
      | Winsor | Orellana         | Vásquez          | 30012002            | M      | JHKEO  | Cochabamba | Winsor2002        | winsoromar12@gmail.com | Pepit@123 |