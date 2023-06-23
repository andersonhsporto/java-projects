package dev.anderson.jwtexample.controller;

import dev.anderson.jwtexample.dto.LoginDTO;
import dev.anderson.jwtexample.dto.RegisterDTO;
import dev.anderson.jwtexample.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO, HttpServletResponse response) {
        return userService.register(registerDTO, response);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginDTO loginDTO) {
        return userService.authenticate(loginDTO);
    }
}
