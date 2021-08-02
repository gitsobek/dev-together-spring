package io.infi.devtogetherapi.controllers.web;

import io.infi.devtogetherapi.controllers.operations.UserOperations;
import io.infi.devtogetherapi.controllers.request.LoginUserRequest;
import io.infi.devtogetherapi.controllers.request.RegisterUserRequest;
import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.dto.response.Response;

public class UserController implements UserOperations {
    @Override
    public Response<UserDto> login(LoginUserRequest loginUserRequest) {
        return null;
    }

    @Override
    public Response<UserDto> register(RegisterUserRequest registerUserRequest) {
        return null;
    }
}
