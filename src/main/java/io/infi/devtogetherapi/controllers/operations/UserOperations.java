package io.infi.devtogetherapi.controllers.operations;

import io.infi.devtogetherapi.controllers.request.LoginUserRequest;
import io.infi.devtogetherapi.controllers.request.RegisterUserRequest;
import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.dto.response.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserOperations {
    @PostMapping("/login")
    Response<UserDto> login(@Valid @RequestBody LoginUserRequest loginUserRequest);

    @PostMapping("/register")
    Response<UserDto> register(@Valid @RequestBody RegisterUserRequest registerUserRequest);
}
