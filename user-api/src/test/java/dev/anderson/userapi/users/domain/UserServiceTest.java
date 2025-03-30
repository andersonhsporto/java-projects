package dev.anderson.userapi.users.domain;

import static dev.anderson.userapi.common.UserConstants.INVALID_INPUT_DTO;
import static dev.anderson.userapi.common.UserConstants.INVALID_INPUT_ENTITY;
import static dev.anderson.userapi.common.UserConstants.VALID_INPUT_DTO;
import static dev.anderson.userapi.common.UserConstants.VALID_INPUT_ENTITY;
import static dev.anderson.userapi.common.UserConstants.VALID_OUTPUT_ENTITY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Test
  void createUser_WithValidData_ReturnsUser() {
    when(userRepository.save(VALID_INPUT_ENTITY)).thenReturn(VALID_OUTPUT_ENTITY);
		
	UserDto sut = userService.create(VALID_INPUT_DTO);
		
	assertThat(sut.name()).isEqualTo(VALID_INPUT_DTO.name());
  }

  @Test
  void createUser_WithValidData_ThrowsException() {
    when(userRepository.save(INVALID_INPUT_ENTITY)).thenThrow(RuntimeException.class);
    
    assertThatThrownBy(() -> userService.create(INVALID_INPUT_DTO)).isInstanceOf(RuntimeException.class);
  }

}
