package io.infi.devtogetherapi.repositories;

import io.infi.devtogetherapi.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DataUserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
