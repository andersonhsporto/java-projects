package dev.anderson.themeparkapijenkins

import dev.anderson.themeparkapijenkins.entities.ThemeParkRide
import dev.anderson.themeparkapijenkins.repositories.ThemeParkRideRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ThemeParkApiJenkinsApplication {

    static void main(String[] args) {
        SpringApplication.run(ThemeParkApiJenkinsApplication, args)
    }

    @Bean
    public CommandLineRunner demo(ThemeParkRideRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new ThemeParkRide("Rollercoaster", "Train ride that speeds you along.", 5, 3));
            repository.save(new ThemeParkRide("Log flume", "Boat ride with plenty of splashes.", 3, 2));
            repository.save(new ThemeParkRide("Teacups", "Spinning ride in a giant tea-cup.", 2, 4));
        };
    }

}
