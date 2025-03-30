# User API

## Description

Example of a simple crud rest api
using [spring boot](https://spring.io/projects/spring-boot) and
[mysql](https://www.mysql.com/).

## Requirements

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - Programming language
- [Maven](https://maven.apache.org/) - Dependency manager
- [MySQL](https://www.mysql.com/) - Database
- [Docker](https://www.docker.com/) - Container manager
- [Docker Compose](https://docs.docker.com/compose/) - Container manager
- [Postman](https://www.postman.com/) - API testing

## Installation

This project requires a compatible Java 17 JDK installed and
a MySQL database running.

To help the installation process, a docker-compose file is provided
with a MySQL database and a instance of the application.

## Docker

To start the containers, run the following command:

```bash
docker-compose up -d
```

This command will start the containers in the background.

To start only the database, run the following command:

```bash
docker-compose up -d database
```

this command will start only the database container.

## Command line

To start the application, run the following command
with a instance of MySQL running:

```bash

mvn spring-boot:run

```

## Database Parameters

For learning purposes, the parameters are hardcoded in the application
and can be changed in
the [application.yaml](https://github.com/andersonhsporto/user-api/blob/main/src/main/resources/application.yaml)
file
or [application-docker.yml](https://github.com/andersonhsporto/user-api/blob/main/src/main/resources/application-docker.yaml)
in
docker environment.

| Parameter         | Default Value               | Description       |
|-------------------|-----------------------------|-------------------|
| Database Host     | localhost or docker service | Database host     |
| Database Port     | 3306                        | Database port     |
| Database Name     | db                          | Database name     |
| Database Username | user                        | Database username |
| Database Password | password                    | Database password |

## Endpoints

The following endpoints are available:

User endpoints:

| Method | Endpoint           | Description       |
|--------|--------------------|-------------------|
| GET    | /api/v1/users      | Get all users     |
| GET    | /api/v1/users/{id} | Get user by id    |
| POST   | /api/v1/users      | Create a new user |
| PUT    | /api/v1/users/{id} | Update user by id |
| DELETE | /api/v1/users/{id} | Delete user by id |

## Examples

To help the testing process, below are some examples of
requests and responses.

The name, username and password, birth date are required fields,
birth date must be in the format dd-MM-yyyy.

The password must be 6 characters long and it will never be returned
for security reasons.

### Create user

To create a new user, send a POST request to the endpoint
which will return the created user.

#### Request:

```bash

curl --location --request POST 'http://localhost:8080/api/v1/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "John Doe",
    "username": "johndoe",
    "password": "123456",
    "dateOfBirth": "01-01-2000"
}'

```

#### Json:

```json
{
  "name": "John Doe",
  "username": "johndoe",
  "password": "123456",
  "dateOfBirth": "01-01-2000"
}
```

#### Return:

```json
{
  "id": 1,
  "name": "John Doe",
  "username": "johndoe",
  "dateOfBirth": "01-01-2000",
  "createdAt": "2021-10-10T00:00:00.000+00:00",
  "updatedAt": "2021-10-10T00:00:00.000+00:00"
}
```

### Update user

To update a user, send a PUT request to the endpoint
which will return the updated user.

##### Request:

```bash
curl --location --request PUT 'http://localhost:8080/api/v1/users/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "John Doe 2",
    "username": "johndoe2",
    "password": "123457",
    "dateOfBirth": "01-01-2000"
}'
```

#### Return:

```json
{
  "id": 1,
  "name": "John Doe 2",
  "username": "johndoe2",
  "dateOfBirth": "01-01-2000",
  "createdAt": "2021-10-10T00:00:00.000+00:00",
  "updatedAt": "2021-10-10T00:00:00.000+00:00"
}
```

### Get user by id

To get a user by id, send a GET request to the endpoint
which will return the user.

#### Request:

```bash
curl --location --request GET 'http://localhost:8080/api/v1/users/1'
```

#### Return:

```json
{
  "id": 1,
  "name": "John Doe 2",
  "username": "johndoe2",
  "dateOfBirth": "01-01-2000",
  "createdAt": "2021-10-10T00:00:00.000+00:00",
  "updatedAt": "2021-10-10T00:00:00.000+00:00"
}
```

### Get all users

To get all users, send a GET request to the endpoint
which will return all users.

#### Request:

```bash
curl --location --request GET 'http://localhost:8080/api/v1/users'
```

#### Return:

```json
[
  {
    "id": 1,
    "name": "John Doe 2",
    "username": "johndoe2",
    "dateOfBirth": "01-01-2000",
    "createdAt": "2021-10-10T00:00:00.000+00:00",
    "updatedAt": "2021-10-10T00:00:00.000+00:00"
  },
  {
    "id": 2,
    "name": "John Doe 3",
    "username": "johndoe3",
    "dateOfBirth": "01-01-2000",
    "createdAt": "2021-10-10T00:00:00.000+00:00",
    "updatedAt": "2021-10-10T00:00:00.000+00:00"
  }
]
```

### Delete user by id

To delete a user by id, send a DELETE request to the endpoint
which will return status 204 (No Content).

#### Request:

```bash
curl --location --request DELETE 'http://localhost:8080/api/v1/users/1'
```

#### Return:

```json
204 No Content
```

## Contact Information

If you have any questions, suggestions or comments, please contact me.
through the [email](mailto:anderson.higo2@gmail.com) or
[linkedin](https://www.linkedin.com/in/andersonhsporto/).
