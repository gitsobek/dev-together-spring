package io.infi.devtogetherapi.repositories;

import io.infi.devtogetherapi.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    User save(User user);
}
