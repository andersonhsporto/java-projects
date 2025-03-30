FROM maven:3.8.6-openjdk-18 AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests


FROM eclipse-temurin:18-jdk
RUN mkdir /app
COPY --from=build /project/target/sacola-API-0.0.1-SNAPSHOT.jar /app/sacola-API-0.0.1-SNAPSHOT.jar
WORKDIR /app
CMD "java" "-jar" "sacola-API-0.0.1-SNAPSHOT.jar"
