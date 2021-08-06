package io.infi.devtogetherapi.controllers.operations;

import io.infi.devtogetherapi.controllers.request.LoginUserRequest;
import io.infi.devtogetherapi.controllers.request.RegisterUserRequest;
import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.dto.response.Response;

public interface UserOperations {
    Response<UserDto> login(LoginUserRequest loginUserRequest);

    Response register(RegisterUserRequest registerUserRequest);
}
