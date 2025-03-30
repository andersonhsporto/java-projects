# Jwt Example

## Description

This is a simple example of how to use JWT in spring security 6.

## Technologies

- [Java 17](https://www.java.com/pt-BR/) - Programming language
- [Spring Boot 3.1.1](https://spring.io/projects/spring-boot) - MVC Framework
- [Spring Security 6.0.0](https://spring.io/projects/spring-security) - Security Framework
- [Spring Data JPA 3.2.1](https://spring.io/projects/spring-data-jpa) - Data access framework
- [Postgres 13](https://www.postgresql.org/) - Database
- [Gradle](https://gradle.org/) - Build tool
- [Docker](https://www.docker.com/) - Containerization platform


## How to run

1. Clone this repository
2. Start a local postgres database or use docker-compose to start one
2. Run `gradle bootRun`

### Docker

To start a postgres database using docker-compose, run the following command:

```shell
docker-compose up -d
```


## How to test

To register a new user, send a POST request to `http://localhost:8080/api/v1/user/register` with the following body:

```json
{
  "firstName": "firstName",
  "lastName": "lastName",
  "email": "{valid-email}",
  "password": "{password}"
}
```

This will return a 201 status code if the user was created successfully and return a jwt token
in the response header and body.

To authenticate, send a POST request to `http://localhost:8080/api/v1/user/authenticate` with the following body:

```json
{
  "email": "{valid-email}",
  "password": "{password}"
}
```



## Contact Information

If you have any questions, suggestions, or critiques, please contact me using [email](mailto:anderson.higo2@gmail.com)
or through [LinkedIn](https://www.linkedin.com/in/andersonhsporto/).