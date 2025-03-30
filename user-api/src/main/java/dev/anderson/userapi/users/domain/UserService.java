package dev.anderson.userapi.users.domain;

import java.util.List;
import org.springframework.stereotype.Service;
import dev.anderson.userapi.users.exceptions.UserNotFoundExcepton;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  public UserDto create(UserDto dto) {
    UserEntity entity = UserDto.toEntity(dto);

    userRepository.save(entity);
    return UserDto.fromEntity(entity);
  }

  public UserDto update(Long id, UserDto dto) throws UserNotFoundExcepton {
    UserEntity entity = userRepository.findById(id)
        .orElseThrow(UserNotFoundExcepton::new);

    userMapper.updateFromDto(dto, entity);
    userRepository.save(entity);
    return UserDto.fromEntity(entity);
  }

  public UserDto get(Long id) throws UserNotFoundExcepton {
    return userRepository.findById(id)
        .map(UserDto::fromEntity)
        .orElseThrow(UserNotFoundExcepton::new);
  }

  public List<UserDto> list() {
    List<UserEntity> entityList = userRepository.findAll();

    return userMapper.toDtoList(entityList);
  }

  @Transactional
  public void delete(Long id) throws UserNotFoundExcepton {
    UserEntity entity = userRepository
        .findById(id)
        .orElseThrow(UserNotFoundExcepton::new);

    userRepository.delete(entity);
  }

}
