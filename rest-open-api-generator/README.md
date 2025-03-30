# Open Api Code Generator

## Description

This is a basic Open Api Code Generator. 
It is a simple tool that generates code from an Open Api specification file. 
It is written in java and uses the 
[Open Api Generator]( https://openapi-generator.tech/) library to
generate the boilerplate code using a yaml file as input.

## Open Api Generator

The Open Api Generator is a tool that generates code from an Open Api
specification file. It supports a lot of languages and frameworks.

For more information, please visit the [Open Api Generator]( https://openapi-generator.tech/) website.

## Usage

To use this tool, you need to have java (version 17 or higher) and
maven installed on your machine.

To generate the code, you need to run the following command:

```shell
mvn clean install
```

This will generate the code in the `target/` folder.

After that, you can run the following command to run the application:

```shell
java -jar target/open-api-code-generator-0.0.1-SNAPSHOT.jar
```

or you can run the following command to start the spring boot application:

```shell
mvn spring-boot:run
```

## Configuration

The configuration of the code generator is done in the `beer.yml` file
located in the `src/main/resources/templates/` folder.

This file will generate all interfaces and classes needed to create a
beer application.


## Usage

After running the application, you can access the swagger-ui page at

```shell
localhost:8080/api/v1/swagger-ui/index.html
```