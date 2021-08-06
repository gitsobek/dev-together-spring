package io.infi.devtogetherapi.controllers.web;

import io.infi.devtogetherapi.controllers.operations.TagOperations;
import io.infi.devtogetherapi.dto.response.Response;
import io.infi.devtogetherapi.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/${api.version}/tags")
public class TagController implements TagOperations {
    private final TagService tagService;

    @Override
    @GetMapping
    public Response findAll() {
        return tagService.findAll();
    }
}
