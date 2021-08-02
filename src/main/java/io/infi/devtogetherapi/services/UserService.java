package io.infi.devtogetherapi.services;

import io.infi.devtogetherapi.controllers.operations.UserOperations;
import io.infi.devtogetherapi.controllers.request.LoginUserRequest;
import io.infi.devtogetherapi.controllers.request.RegisterUserRequest;
import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.dto.response.Response;
import io.infi.devtogetherapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService implements UserOperations {
    private final UserRepository userRepository;

    @Override
    public Response<UserDto> login(LoginUserRequest loginUserRequest) {
        return null;
    }

    @Override
    public Response<UserDto> register(RegisterUserRequest registerUserRequest) {
        return null;
    }}
