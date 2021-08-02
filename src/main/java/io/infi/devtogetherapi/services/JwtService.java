package io.infi.devtogetherapi.services;

import io.infi.devtogetherapi.models.User;

public interface JwtService {
    String getSubject(String token);

    String getToken(User user);
}