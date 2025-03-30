package dev.anderson.userapi.users.web;

import java.util.List;

import dev.anderson.userapi.config.CreateValidation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import dev.anderson.userapi.users.domain.UserDto;
import dev.anderson.userapi.users.domain.UserService;
import dev.anderson.userapi.users.exceptions.UserNotFoundExcepton;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {
	
	private final UserService userservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto create(@Validated(CreateValidation.class) @RequestBody UserDto dto) {
		return userservice.create(dto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDto update(@PathVariable Long id, @Validated @RequestBody UserDto dto) throws UserNotFoundExcepton {
		return userservice.update(id, dto);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UserDto get(@PathVariable Long id) throws UserNotFoundExcepton {
		return userservice.get(id);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserDto> list() {
		return userservice.list();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws UserNotFoundExcepton {
	  userservice.delete(id);
	}

}
