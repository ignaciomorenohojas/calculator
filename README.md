# Calculator

Repositorio para la API Calculator que es una prueba técnica pata Sanitas.

Implementación de un microservicio "calculadora", usando maven + spring-boot

Este microservicio expone una API que, a partir de unos parámetros de entrada, realiza operaciones aritméticas. 

Es una versión POC, por lo que solo es capaz de realizar sumas y restas de dos elementos, aunque se deja preparado para que en futuras versiones haya otros tipos de operaciones y de mayor complejidad. 

Utiliza un jar que contiene una API para tracear las operaciones que se han invocado por el microservicio para tracear el resultado de la operación.

El objeto de este documento no solo es explicar el funcionamiento del microservicio, sino explicar como se ha planteado la solución.

## Planteamiento de la solución
Para la implementación del microservicio se han seguido las siguientes pautas:
1. Creación del esqueleto del microservicio utilizando Spring-Boot y Maven. Para utilizar CleanCode con principios SOLID, se toma la decisión de utilizar una estructura de paquetes acorde con la arquitectura Hexagonal.
1. Utilización del concepto DDD (Domain-drive design) para la creación de la estructura del modelo.
   1. Para dejar abierta la posibilidad de añadir más operaciones a la calculadora, se toma la decisión de utilizar un Enum con los tipos de operaciones que el microservicio puede realizar.
   1. Se utiliza el patron factory para la creación de operaciones, lo que supone crear una clase abstracta de operaciones y una clase que extienda de ella por cada operación implementada.
   1. El Enum con los tipos de operaciones asignará a cada tipo de operación su implementación.
1. Utilización del concepto TDD (Test-drive design) para la comprobación y mejora del modelo creado.
1. Creación de los casos de uso y su implementación. En este POC solo hay un caso de uso que es el cálculo de la operación.
1. Creación del controlador solicitado en las especificaciones del POC. 
   1. Se toma la decisión de que el tipo de operación se pase como un parámetro de la ruta (Path parámeter) y los argumentos como una lista pasada por un parámetro de la llamada.
   1. Se incorpora el paquete de traceo solicitado en las especificaciones del POC.
1. Gestión de excepciones y errores global mediante Controller Advice de Spring
1. Creación de las pruebas unitarias del controlador.
1. Mejora de la documentación mediante Swagger y este Readme.

## Pasos para la ejecución del microservicio

Requisitos previos para la compilación:

1. Tener instalado y configurado JDK 11.
1. Tener instalado y configurado el repositorio central de MAVEN.
1. Instalar la librería "trace" mediante la orden:
  
    mvn install:install-file -Dfile=tracer-1.0.0.jar -DgroupId=io.corp -DartifactId=calculator -Dversion=1.0.0 -Dpackaging=jar -DgeneratedPom=true

1. Descargar el Repositorio clonándolo de gotHub: 

    git clone https://github.com/ignaciomorenohojas/calculator.git

1. Compilar el microservicio mediante la orden: 

    mvn clean install

1. Ejecutar el microservicio ejecutando el siguiente comando en el directorio raíz del proyecto:

    java -jar target\calculator-0.0.1-SNAPSHOT.jar

1. Al tener documentado la API con Swagger, puede verse la documentación en la siguiente ruta:

    http://localhost:8081/api-calculator/swagger-ui.html

## Uso del microservicio
El microservicio cuenta con dos llamadas:

### Listado de operaciones disponibles
Para conocer las diferentes operaciones que tiene el microservicio, se dispone de una llamada de tipo GET sin parámetros. 

La llamada es: http://localhost:8081/calculator/operation-types

Devuelve un listado con los códigos de las diferentes operaciones disponibles en el microservicio.

### Ejecución de una operación

Para calcular operaciones aritméticas se utiliza una llamada de tipo GET con un parámetro de tipo path con el código de la operación. Cada operación tiene un número variable de argumentos. Estos argumentos se pasan mediante un parámetro llamado "arguments" cuyo valor es una lista de números separados por comas.

La llamada para la operación suma es: http://localhost:8081/calculator/ADD?arguments=1,-14
La llamada para la operación resta es: http://localhost:8081/calculator/SUBTRACT?arguments=1,-14

Devuelven un estado 200 y un valor numérico en caso de que la operación se ejecute sin contratiempos.

Devuelve un estado 400 y un texto de error en caso de que la operación no pueda ejecutarse.

## Extensión del microservicio

El microservicio se ha diseñado para poder extenderlo de manera que no influya en el resto de la lógica del microservicio.

Se ha implementado un patron Factory que permite desacoplar cada operación del resto de lógica. Para crear una nueva operación hay que realizar estos pasos:
1. Crear una clase que implemente el interface OperationFactory. Esta clase tendrá un método llamado "calculate" que, dada una lista de argumentos numéricos, devuelva un resultado.
2. Añadir la nueva operación al Enum llamado "OperationType", asignándole una nueva instancia de la nueva operación creada.  
