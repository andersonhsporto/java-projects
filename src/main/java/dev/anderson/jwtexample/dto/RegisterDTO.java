package dev.anderson.jwtexample.dto;

import dev.anderson.jwtexample.entities.RoleName;
import dev.anderson.jwtexample.entities.UserEntity;
import jakarta.validation.constraints.Email;

import java.util.List;

public record RegisterDTO(

        String firstName,

        String lastName,

        @Email
        String email,

        String password) {

        public static UserEntity toEntity(RegisterDTO registerDto) {
                return new UserEntity(
                        registerDto.firstName(),
                        registerDto.lastName(),
                        registerDto.email()
                );
        }
}
