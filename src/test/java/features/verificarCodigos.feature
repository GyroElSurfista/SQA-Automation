# author: Winsor Orellana
# date: 01/05/2024
# language: es

Requisito: Verificar que los códigos de registro se envíen al correo electrónico de un usuario

  Este test case verifica que los códigos de registro solicitados durante el proceso
  de registro se envíen al correo electrónico del usuario

  Escenario: Registrar usuario

  Esquema del escenario: Un usuario registrándose en la aplicación web
    Dado Un usuario cliente registrándose en "https://friender.vercel.app/registrar"
    Cuando Llena parcialmente el formulario con los datos "<Nombre>", "<Apellido paterno>", "<Apellido materno>", "<Fecha de nacimiento>", "<Género>", "<Ubicación>", "<Nombre de usuario>", "<Contraseña>", "<Confirmar contraseña>"
    Y Pulsa el botón "Siguiente"
    Y Pulsa el botón "Enviar Código"
    Entonces Recibe códigos de verificación en la bandeja de su correo electrónico
    Ejemplos:
      | Nombre | Apellido paterno | Apellido materno | Fecha de nacimiento | Género | Ubicación | Nombre de usuario | Contraseña | Confirmar contraseña |

