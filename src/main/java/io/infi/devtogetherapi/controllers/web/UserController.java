package io.infi.devtogetherapi.controllers.web;

import io.infi.devtogetherapi.controllers.operations.UserOperations;
import io.infi.devtogetherapi.controllers.request.LoginUserRequest;
import io.infi.devtogetherapi.controllers.request.RegisterUserRequest;
import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.dto.response.Response;
import io.infi.devtogetherapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/${api.version}/auth")
public class UserController implements UserOperations {
    private final UserService userService;

    @Override
    public Response<UserDto> login(LoginUserRequest loginUserRequest) {
        return null;
    }

    @Override
    public Response<UserDto> register(RegisterUserRequest registerUserRequest) {
        return userService.register(registerUserRequest);
    }
}
