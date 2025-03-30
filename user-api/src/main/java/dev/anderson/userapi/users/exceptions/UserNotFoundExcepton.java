package dev.anderson.userapi.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExcepton extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundExcepton() {
		super("User not found");
	}

}
