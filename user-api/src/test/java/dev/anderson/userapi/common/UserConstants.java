package dev.anderson.userapi.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import dev.anderson.userapi.users.domain.UserDto;
import dev.anderson.userapi.users.domain.UserEntity;

public class UserConstants {

  public static final UserDto VALID_INPUT_DTO =
      UserDto.builder().name("Valid name")
      .username("Valid username")
      .password("very-safe-password")
      .dateOfBirth(LocalDate.of(1999, 1, 1))
      .build();

  public static final UserDto INVALID_INPUT_DTO = UserDto.builder().name(null).username(null)
      .password(null).dateOfBirth(null).build();

  public static final UserEntity VALID_INPUT_ENTITY =
      UserEntity.builder().name("Valid name").username("Valid username")
          .password("very-safe-password").dateOfBirth(LocalDate.of(1999, 1, 1)).build();

  public static final UserEntity VALID_OUTPUT_ENTITY =
      UserEntity.builder().name("Valid name").username("Valid username")
          .password("very-safe-password").dateOfBirth(LocalDate.of(1999, 1, 1))
          .createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build();
  
  public static final UserEntity INVALID_INPUT_ENTITY =
      UserEntity.builder().name(null).username(null)
      .password(null).dateOfBirth(null).build();

}
