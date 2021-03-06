package io.infi.devtogetherapi.handlers;

import io.infi.devtogetherapi.dto.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation error. Check 'errors' field for details.",
                ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT),
                ((ServletWebRequest) request).getRequest().getRequestURI()
        );

        ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .forEach(x -> errorResponse.addValidationError(x.getField(), x.getDefaultMessage()));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                buildErrorResponse(request, HttpStatus.METHOD_NOT_ALLOWED.value(), "Method is not supported."),
                HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @Override
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<>(
                buildErrorResponse(request, HttpStatus.NOT_FOUND.value(), "No such endpoint"),
                HttpStatus.NOT_FOUND
        );
    }

    private ErrorResponse buildErrorResponse(WebRequest request, int status, String message) {
        ErrorResponse errorResponse = new ErrorResponse(
                status,
                message,
                ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT),
                ((ServletWebRequest) request).getRequest().getRequestURI()
        );

        errorResponse.setMethod(((ServletWebRequest) request).getHttpMethod().toString());

        return errorResponse;
    }
}
