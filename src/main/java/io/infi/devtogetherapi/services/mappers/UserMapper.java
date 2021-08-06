package io.infi.devtogetherapi.services.mappers;

import io.infi.devtogetherapi.dto.models.UserDto;
import io.infi.devtogetherapi.models.User;
import io.infi.devtogetherapi.services.JwtService;

public class UserMapper {
    public static UserDto collect(User user, JwtService jwtService) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .token(jwtService.getToken(user))
                .bio(user.getBio())
                .image(user.getImage())
                .joinedAt(user.getCreatedAt().toString())
                .build();
    }
}
