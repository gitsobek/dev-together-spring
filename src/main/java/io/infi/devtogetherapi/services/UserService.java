package io.infi.devtogetherapi.services;

import io.infi.devtogetherapi.controllers.operations.UserOperations;
import io.infi.devtogetherapi.controllers.request.LoginUserRequest;
import io.infi.devtogetherapi.controllers.request.RegisterUserRequest;
import io.infi.devtogetherapi.dto.enums.Roles;
import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.dto.response.Response;
import io.infi.devtogetherapi.models.User;
import io.infi.devtogetherapi.repositories.UserRepository;
import io.infi.devtogetherapi.services.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserOperations {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Response<UserDto> login(LoginUserRequest loginUserRequest) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(loginUserRequest.getEmail())
                .orElseThrow(() -> Response.badRequest(String.format("Email '%s' does not exist.", loginUserRequest.getEmail()))));

        if (!passwordEncoder.matches(loginUserRequest.getPassword(), userOptional.get().getPassword())) {
            throw Response.unauthorized("Password is incorrect.");
        }

        return Response.<UserDto>ok()
                .setData(UserMapper.collect(userOptional.get(), jwtService))
                .setMessage("User has been logged successfully.");
    }

    @Override
    public Response register(RegisterUserRequest registerUserRequest) {
        Optional<User> userOptional = userRepository.findByEmail(registerUserRequest.getEmail());

        if (userOptional.isPresent()) {
            throw Response.badRequest(String.format("Email '%s' is already taken.", registerUserRequest.getEmail()));
        }

        if (userOptional.isPresent() && userOptional.get().getUsername() == registerUserRequest.getEmail()) {
            throw Response.badRequest(String.format("Username '%s' is already taken.", registerUserRequest.getUsername()));
        }

        User user = User.builder()
                .username(registerUserRequest.getUsername())
                .email(registerUserRequest.getEmail())
                .password(passwordEncoder.encode(registerUserRequest.getPassword()))
                .role(Roles.USER)
                .build();
        userRepository.save(user);

        return Response.ok()
                .setMessage("User has been registered successfully.");
    }
}
