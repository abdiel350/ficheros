-Se procede a la creacion de un nuevo proyecto usando Android Studio Koala Feature Drop version 2024.1.2 -Luego New Project ,
seguido procederemos a utilizar la plantilla Empty Activity. -En nuestra siguiente ventana, en donde dice Name se procede a colocar nuestro nombre de proyecto el cual es ficheros,
seguido de nuestro Package name el cual llevara como nombre es.ua.eps.ficheros, lenguaje Java, SDK API 24 ("Nougat"; Android 7.0), seguido de Finish para la creación.
-El siguiente paso seria la creación de nuestro dispositivo virtual: Create Virtual Device,
seleccionamos la opcion Phone seguido de Pixel 2, API 34 y la version de Android (14).Se debe utilizar Gradle 8.7 que es la version que da Koala por defecto.

-El mayor desafío radica en gestionar el almacenamiento externo y compatibilidad entre versiones de Android, ya que los cambios en las API y restricciones de permisos pueden causar problemas.
-El manejo de errores y mensajes de retroalimentación es crucial para lograr el ejercicio-
-El manejo de estados: MEDIA_MOUNTED, MEDIA_MOUNTED_READ_ONLY es muy importante para que todo funcione y la creacion del archivo, la lectura, escritura, entre otros.
