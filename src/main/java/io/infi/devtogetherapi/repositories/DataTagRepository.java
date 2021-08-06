package io.infi.devtogetherapi.repositories;

import io.infi.devtogetherapi.models.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DataTagRepository extends CrudRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}
