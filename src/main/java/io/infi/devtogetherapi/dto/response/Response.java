package io.infi.devtogetherapi.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.infi.devtogetherapi.exceptions.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {
    private Integer status;
    private T data;
    private String message;

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(200);
        return response;
    }

    public static BadRequestException badRequest(String message, Object... args) {
        return new BadRequestException(String.format(message, args));
    }

    public static UnauthorizedException unauthorized(String message, Object... args) {
        return new UnauthorizedException(String.format(message, args));
    }

    public static ForbiddenException forbidden(String message, Object... args) {
        return new ForbiddenException(String.format(message, args));
    }

    public static NotFoundException notFound(String message, Object... args) {
        return new NotFoundException(String.format(message, args));
    }

    public static ServerErrorException serverError(String message, Object... args) {
        return new ServerErrorException(String.format(message, args));
    }
}
