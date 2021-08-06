package io.infi.devtogetherapi.services;

import io.infi.devtogetherapi.controllers.operations.TagOperations;
import io.infi.devtogetherapi.dto.response.Response;
import io.infi.devtogetherapi.models.Tag;
import io.infi.devtogetherapi.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class TagService implements TagOperations {
    private final TagRepository tagRepository;
    @Override
    public Response<List<String>> findAll() {
        List<String> tags = StreamSupport.stream(tagRepository.findAll().spliterator(), false)
                .map(Tag::getName)
                .collect(Collectors.toList());

        return Response.<List<String>>ok()
                .setData(tags);
    }
}
