package io.infi.devtogetherapi.controllers.operations;

import io.infi.devtogetherapi.dto.response.Response;
import java.util.List;

public interface TagOperations {
    Response<List<String>> findAll();
}
