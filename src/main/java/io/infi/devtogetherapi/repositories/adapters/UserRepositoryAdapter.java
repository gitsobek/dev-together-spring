package io.infi.devtogetherapi.repositories.adapters;

import io.infi.devtogetherapi.models.User;
import io.infi.devtogetherapi.repositories.DataUserRepository;
import io.infi.devtogetherapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final DataUserRepository dataUserRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return dataUserRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return dataUserRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return dataUserRepository.save(user);
    }
}
