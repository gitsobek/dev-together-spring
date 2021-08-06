package io.infi.devtogetherapi.controllers.web;

import io.infi.devtogetherapi.controllers.operations.UserOperations;
import io.infi.devtogetherapi.controllers.request.LoginUserRequest;
import io.infi.devtogetherapi.controllers.request.RegisterUserRequest;
import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.dto.response.Response;
import io.infi.devtogetherapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/${api.version}/auth")
public class UserController implements UserOperations {
    private final UserService userService;

    @Override
    @PostMapping("/login")
    public Response<UserDto> login(@RequestBody @Valid LoginUserRequest loginUserRequest) {
        return userService.login(loginUserRequest);
    }

    @Override
    @PostMapping("/register")
    public Response register(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        return userService.register(registerUserRequest);
    }
}
