# Foro-hub
Oracle Next Education - Proyecto final de la formación de Backend con Java 



<h1 align="center"> Foro-hub // Back-End para Foro :speech_balloon::coffee: </h1>







# Descripción
Este proyecto es el back-end de un Foro donde los usuarios puedan interactuar entre ellos, hacer preguntas y realizar respuestas. Desarrollado en Java y Spring Boot utilizando un JWT para autenticar el login de los usuarios antes de poder interactuar con la aplicacion


# Autenticación

La autenticación en ForoHub se maneja mediante JSON Web Tokens (JWT). Aquí se describe el flujo de autenticación:

- Inicio de Sesión:

El usuario envía sus credenciales (nombre de usuario y contraseña) al endpoint /login.
El controlador recibe estas credenciales y crea un objeto de autenticación.
Posteriormente se autentica al usuario. Si la autenticación es exitosa, se genera un token JWT.

- Generación del Token JWT:

El JWT utiliza un algoritmo HMAC256.
El token incluye el login del usuario como sujeto, su id y una fecha de expiración de 2 horas.

- Autorización de Peticiones:

Para acceder a otros endpoints protegidos, el cliente debe incluir el token JWT en el encabezado Authorization de sus peticiones HTTP.
Si el token es válido, se autentica al usuario y se configura el contexto de seguridad.

- Endpoints Protegidos:

Solo los usuarios autenticados pueden acceder a los endpoints protegidos, donde se permite el acceso público solo al endpoint /login y se requiere autenticación para cualquier otra petición.




# Tecnologias Utilizadas
- Java
- MySql
- [JWT](https://jwt.io/)







<h3 align="left">Languages and Tools:</h3>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="40" height="40"/> </a> <a href="https://postman.com" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="postman" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>



# 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jean-angel-gomez-ramirez/)


