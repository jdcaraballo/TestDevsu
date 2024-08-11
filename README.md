# 🦾  Reto Devsu


### **Automatizado Por:**
## Jhonatan David Caraballo Ortiz

#### Arquetipo de pruebas automatizadas usando SerenityBDD con Screenplay
#### Herramientas y Complementos

|                                                                               **IntelliJ**                                                                                |**Java**|**Gradle**|
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------:| :----: | :----:  |
| [<img width="50" height="50" src="https://cdn.iconscout.com/icon/free/png-128/intellij-idea-569199.png">](https://www.jetbrains.com/es-es/idea/download/#section=windows) | [<img height="60" src="https://www.oracle.com/a/ocom/img/cb71-java-logo.png">](https://www.oracle.com/java/technologies/downloads/) | [<img height="50" src="https://gradle.org/images/gradle-knowledge-graph-logo.png?20170228">](https://gradle.org/releases/) |

> **NOTA**:

> * Para ejecutar el proyecto se recomienda minimo las siguientes versiones: 
>   * IntelliJ Community Edition 2023.3
>   * Java JDK 21
>   * Gradle 8.7
> * Una vez obtenido IntelliJ es necesario instalar los plugins de Gherkin y Cucumber for Java. (
    *[Guia de instalación plugins en intellij](https://www.jetbrains.com/help/idea/managing-plugins.html)*)

## Ejecución local

0. Clonar el proyecto

```bash
  git clone https://github.com/jdcaraballo/TestDevsu.git 
```

Para correr el proyecto de manera local se debe realizar los siguientes pasos:

1. Definir el tag de los tipos de tests que se van a ejecutar, esto lo hacemos en el archivo WebRunnerTest.

```
tags = "not @karate and not @ManualTest and not @Mobiletest"
```

2. Definir el driver a usarse en serenity.properties.

```
#====>CONFIG DRIVER
webdriver.driver=chrome
```

## Comandos

### Comandos SerenityBDD

Para ejecutar todos los escenarios por linea de comandos

```bash
  ./gradlew clean test --tests "runners.com.automationtest.WebRunnerTest"
```

Para ejecutar escenarios que contengan un tag especifico

```bash
  ./gradlew clean test --tests -Dcucumber.filter.tags="@test" runners.com.automationtest.WebRunnerTest
```

Para ejecutar los escenarios enviando variables de ambiente

```bash
  ./gradlew clean test --tests "runners.com.automationtest.WebRunnerTest" -Dvariable1=test
```


## Construido con

* BDD - Estrategia de desarrollo
* Screenplay - Patrón de diseño
* Gradle - Manejador de dependencias
* Cucumber - Framework para automatizar pruebas BDD
* Serenity BDD - Biblioteca de código abierto para la generación de reportes
* Gherkin - Lenguaje Business Readable DSL (Lenguaje especifico de dominio legible por el negocio)

## Ejecución compra de dos productos en Demoblaze

1. Para esta prueba se quiere hacer un flujo automatizado la la compra de dos dispositivos tecnológicos tipo celular
2. se han aplicado los principios SOLID para el mayor entendimiento y desarrollo de la aautomatizión.
3.
