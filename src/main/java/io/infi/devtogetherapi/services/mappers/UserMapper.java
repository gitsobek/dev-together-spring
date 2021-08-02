package io.infi.devtogetherapi.services.mappers;

import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.models.User;

public class UserMapper {
    public static UserDto collect(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .token("123")
                .bio(user.getBio())
                .image(user.getImage())
                .build();
    }
}
