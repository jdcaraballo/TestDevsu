# 🦾  Reto Devsu API y Web


### **Automatizado Por:**
## Jhonatan David Caraballo Ortiz

#### Automated Testing Archetype Using SerenityBDD with Screenplay
#### ools and Add-ons

|                                                                               **IntelliJ**                                                                                |**Java**|**Gradle**|
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------:| :----: | :----:  |
| [<img width="50" height="50" src="https://cdn.iconscout.com/icon/free/png-128/intellij-idea-569199.png">](https://www.jetbrains.com/es-es/idea/download/#section=windows) | [<img height="60" src="https://www.oracle.com/a/ocom/img/cb71-java-logo.png">](https://www.oracle.com/java/technologies/downloads/) | [<img height="50" src="https://gradle.org/images/gradle-knowledge-graph-logo.png?20170228">](https://gradle.org/releases/) |

> **In this challenge, an integration of API and Web flows has been done using Serenity and Karate to have the flows integrated into a single project.**


> **A continuación se encuentran 3 flujos automatizados distribuidos de la siguiente manera**
> * 1  Web flow for purchasing two devices on the Demoblaze page automated with SerenityBDD, Java 21, Gradle 8.7
> * 2  Flows for Successful Registration and Failed Registration automated with Karate
> * 2  Flows for Successful Login and Failed Login automated with Karate

> **NOTE**:
> > * There are two Runners, one for Web and another for APIs; execute according to the requirement, taking into account the tags on line 35 for API and line 26 for Web.

> * To run the project, the following minimum versions are recommended:
>   * IntelliJ Community Edition 2023.3
>   * Java JDK 21
>   * Gradle 8.7
> * Once IntelliJ is obtained, it is necessary to install the Gherkin and Cucumber for Java plugins. (
    *[Guia de instalación plugins en intellij](https://www.jetbrains.com/help/idea/managing-plugins.html)*)

## Ejecución local

0. Clone project

```bash
  git clone https://github.com/jdcaraballo/TestDevsu.git 
```

To run the project locally, the following steps should be followed:

1. Define the tag for the types of tests to be executed; this is done in the WebRunnerTest file.

```
tags = "not @karate and not @ManualTest and not @Mobiletest"
```

2. Define the driver to be used in the serenity.properties file.

```
#====>CONFIG DRIVER
webdriver.driver=chrome
```

## Comandos

### Comandos SerenityBDD

To execute all scenarios from the command line:

```bash
  ./gradlew clean test --tests "runners.com.automationtest.WebRunnerTest"
```

To run scenarios that contain a specific tag:

```bash
  ./gradlew clean test --tests -Dcucumber.filter.tags="@test" runners.com.automationtest.WebRunnerTest
```

Para ejecutar los escenarios enviando variables de ambiente

```bash
  ./gradlew clean test --tests "runners.com.automationtest.WebRunnerTest" -Dvariable1=test
```


## Built with
* BDD - Development Strategy
* Screenplay - Design Pattern
*  Karate
*  Gradle - Dependency Manager
*  Cucumber - Framework for Automating BDD Tests
*  Serenity BDD - Open-source Library for Report Generation


## xecution of Purchase of Two Products on Demoblaze

1. This test aims to automate the purchase flow of two cell phone devices.
2. SOLID principles have been applied to enhance understanding and development of the automation.

