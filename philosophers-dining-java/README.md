# Philosophers dinner

[WORK IN PROGRESS]

## Description

This project is about the famous problem of dining philosophers. It is a classic multi-process synchronization problem. The problem consists of five philosophers sitting at a table who do nothing but think and eat. Between each philosopher, there is a single fork. As we know, philosophers are busy thinking, they need both forks to eat, so the question is how to make each philosopher eat without starving others. The problem is how to design a discipline of behavior (a concurrent algorithm) such that each philosopher gets to eat and never starves; i.e., for any outcome, each philosopher should eventually be able to eat.

## Technologies

- [Java 21](https://openjdk.java.net/projects/jdk) - Java Development Kit
- [Maven](https://maven.apache.org/) - Dependency Management

## Usage

### Arguments

| Argument                                  | Description                                                           | Default value |
|-------------------------------------------|-----------------------------------------------------------------------|---------------|
| number_of_philosophers                    | Number of philosophers                                                | 5             |
| time_to_die                               | Time in milliseconds after which a philosopher dies                   | 1000          |
| time_to_eat                               | Time in milliseconds that a philosopher takes to eat                  | 1000          |
| time_to_sleep                             | Time in milliseconds that a philosopher takes to sleep                | 1000          |
| number_of_times_each_philosopher_must_eat | Number of times each philosopher must eat before the simulation stops | 0             |

Build this project with maven and run the jar file with the following arguments:

```bash
mvn clean package
java -jar target/philosophers-dinner-1.0-SNAPSHOT.jar {ARGS}
```

# Utils

- [Philosophers dinner](https://blog.pantuza.com/artigos/o-jantar-dos-filosofos-problema-de-sincronizacao-em-sistemas-operacionais) - Blog post about the problem in portuguese
- [Philosophers dinner](https://en.wikipedia.org/wiki/Dining_philosophers_problem) - Wikipedia article about the problem
- [Philosophers dinner](https://www.geeksforgeeks.org/dining-philosopher-problem-using-semaphores/) - Geeks for Geeks article about the problem


