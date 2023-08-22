# Sales - Client - Employee | Swing App

## Description

This is a simple Swing application that allows you to manage clients, vendors, employees and products,
and also to manage the sales of products.

## Technologies

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) - Programming language
- [Swing](https://docs.oracle.com/javase/tutorial/uiswing/) - GUI toolkit
- [Maven](https://maven.apache.org/) - Dependency manager
- [JDBC](https://docs.oracle.com/javase/tutorial/jdbc/) - API for connecting to databases
- [MySQL](https://www.mysql.com/) - Relational database
- [Docker](https://www.docker.com/) - Containerization platform

## System requirements

- Java 17
- Maven
- MySQL Database ( or Docker )

## Installation

### MySQL

If you don't have a MySQL database installed, you can use Docker to create a container with MySQL.
in the root directory of the project, run the following command this will create a container already
with the database and the tables necessary for the application to work.

```bash
	docker compose up -d
```

### Application

After creating the database, you can run the application using the following command:

```bash
	mvn clean compile exec:java
```

# WORK IN PROGRESS

!!! This project is still under development, so not all features are available yet.

## Contact Information

If you have any questions, suggestions, or critiques, please contact me using [email](mailto:anderson.higo2@gmail.com) or through [LinkedIn](https://www.linkedin.com/in/andersonhsporto/).
