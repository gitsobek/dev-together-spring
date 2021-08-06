package io.infi.devtogetherapi.repositories.adapters;

import io.infi.devtogetherapi.models.Tag;
import io.infi.devtogetherapi.repositories.DataTagRepository;
import io.infi.devtogetherapi.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class TagRepositoryAdapter implements TagRepository {
    private final DataTagRepository dataTagRepository;

    @Override
    public Optional<Tag> findByName(String name) {
        return dataTagRepository.findByName(name);
    }

    @Override
    public Iterable<Tag> findAll() {
        return dataTagRepository.findAll();
    }
}
