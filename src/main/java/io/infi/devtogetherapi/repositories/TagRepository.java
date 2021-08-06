package io.infi.devtogetherapi.repositories;

import io.infi.devtogetherapi.models.Tag;

import java.util.Optional;

public interface TagRepository {
    Optional<Tag> findByName(String name);

    Iterable<Tag> findAll();
}
