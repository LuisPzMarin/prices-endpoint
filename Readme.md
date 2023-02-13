# Prices Endpoint Exercise
## Descripción del ejercicio
## Stack Tecnológico
### Software utilizado
* Docker version 23.0.0
* Docker-compose version 1.29.2
* InteliJ IDEA 2020.3.2

### Stack del proyecto (Dockerizado)
* OpenJDK 18
* Maven:3.8.7

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

En caso de que unicamente se quiera compilar el proyecto, se deberá ejecutar con la siguiente opción:
* buildAndServe.sh -b

Si al contrario, se quiere servir el proyecto con una compilación previa, use la siguiente opción:
* buildAndServe.sh -s

## Uso 

Si se ejecuta el script, el contenedor escuchará en el puerto 80. Por ello, unicamente se deberá hacer una llamada post a
*http://localhost/prices/rate* con un cuerpo de llamada que siga este patrón:
```json
{
    "date": "yyyy-MM-dd-HH.mm.ss",
    "productId": Long,
    "brandId": Long
}
```
Esta llamada devolvera los datos buscados, en el formato que se definé en el enunciado del ejercicio. 

### Ejemplo de llamada
```json
{
    "date": "2020-06-14-00.30.00",
    "productId": 35455,
    "brandId": 1
}
```
### Ejemplo de respuesta
```json
{
    "price": 35.5,
    "brandId": 1,
    "productId": 35455,
    "startDateRate": "2020-06-14T00:00:00",
    "requestDateRate": "2020-06-14T00:30:00",
    "endDateRate": "2020-12-31T23:59:59",
    "priceList": 1
}
```
## Test de integración

Se ha creado el archivo src/main/resources/testData.csv en donde se definen los resultados de los test de integración. 
Dichos test se ejecutan y revisan con el script de la siguiente manera
* buildAndServe.sh -t

En caso de que se quiera servir el proyecto después de ejecutar los test, se puede hacer así:
* buildAndServe.sh -ts

### Aclaración sobre los test
Aúnque solo se pedian 5 ejemplos de test, se deció incluir 5 más para comprobar opciones en los que se deba devolver un NOT_FOUND.