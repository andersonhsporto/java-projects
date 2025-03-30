package dev.anderson.userapi.users.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.anderson.userapi.config.CreateValidation;
import dev.anderson.userapi.config.CustomDateSerializer;
import dev.anderson.userapi.config.MultiDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserDto(

    @JsonProperty("id") 
    Long id,

    @NotEmpty(message = "Name is required")
    @JsonProperty("name") 
    String name,

    @NotEmpty(message = "Username is required")
    @JsonProperty("username") 
    String username,

    @NotEmpty(message = "Password is required", groups = {
            CreateValidation.class
    })
    @JsonInclude(Include.NON_NULL) 
    @JsonProperty("password") 
    String password,

    @NotNull(message = "Date of birth is required")
    @JsonProperty("dateOfBirth")
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    LocalDate dateOfBirth,

    @JsonInclude(Include.NON_NULL) 
    LocalDateTime createdAt,

    @JsonInclude(Include.NON_NULL) 
    LocalDateTime updatedAt
    ) {
  public static UserEntity toEntity(UserDto dto) {
    return UserEntity.builder().name(dto.name).username(dto.username).password(dto.password)
        .dateOfBirth(dto.dateOfBirth).build();
  }

  public static UserDto fromEntity(UserEntity entity) {
    return UserDto.builder().id(entity.getId()).name(entity.getName())
        .username(entity.getUsername()).dateOfBirth(entity.getDateOfBirth())
        .createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
  }

}
