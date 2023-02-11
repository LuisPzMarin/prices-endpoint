# Prices Endpoint Exercise
## Descripción del ejercicio
## Stack Tecnológico
### Software utilizado
* Docker version 23.0.0
* Docker-compose version 1.29.2
* InteliJ IDEA 2020.3.2

### Stack del proyecto (Dockerizado)
* OpenJDK 11
* Maven:3.6.0

## Proyecto base
El proyecto se ha creado con la herramienta [Spring Initializr](https://start.spring.io/), añadiendo las siguientes dependencias:
* Spring Boot DevTools
* Spring Web
* Lombok
* H2 Database
* Spring Data JPA

Se han añadido los archivos dockerfile y docker-compose para servir el proyecto con Docker.
Además, se ha diseñado el script buildAndServe.sh para la compilación y gestión del proyecto. Se recomienda el uso del script como superusuario por los posibles problemas con Docker.


## Compilación 

Para compilar y servir el proyecto, deberemos ejecutar el siguiente script:
* buildAndServe.sh 


