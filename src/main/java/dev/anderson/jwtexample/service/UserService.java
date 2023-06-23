package dev.anderson.jwtexample.service;

import dev.anderson.jwtexample.dto.LoginDTO;
import dev.anderson.jwtexample.dto.RegisterDTO;
import dev.anderson.jwtexample.entities.RoleName;
import dev.anderson.jwtexample.entities.UserEntity;
import dev.anderson.jwtexample.repository.UserRepository;
import dev.anderson.jwtexample.security.JWTUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final JWTUtils jwtUtils;

    public ResponseEntity<?> register(RegisterDTO registerDto, HttpServletResponse response) {
        if (userRepository.findByEmail(registerDto.email()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        UserEntity userEntity = RegisterDTO.toEntity(registerDto);
        String salt = BCrypt.gensalt();
        String passwordDecoded = BCrypt.hashpw(registerDto.password(), salt);

        userEntity.setSalt(salt);
        userEntity.setPassword(passwordDecoded);
        userEntity.setRoles(RoleName.generateUserRole());

        userRepository.save(userEntity);

        String token = jwtUtils.generateToken(
                userEntity.getEmail(),
                Collections.singletonList(userEntity.getRoles().get(0).getRoleName())
        );

        response.setHeader("Authorization", token);

        return ResponseEntity.ok().body(token);
    }


    public String authenticate(LoginDTO loginDto) {
        try {
            UserEntity userEntity = userRepository.findByEmail(loginDto.email()).orElseThrow();
            if (BCrypt.checkpw(loginDto.password(), userEntity.getPassword())) {
                return jwtUtils.generateToken(
                        userEntity.getEmail(),
                        Collections.singletonList(userEntity.getRoles().get(0).getRoleName())
                );
            } else {
                throw new Exception("Invalid password");
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
