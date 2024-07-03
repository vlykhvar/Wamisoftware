package com.geometry.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.geometry.api.model.response.ServiceResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.geometry.common.enums.ApplicationException.INTERNAL_ERROR;
import static com.geometry.common.enums.ApplicationException.JSON_PROCESSING;
import static com.geometry.common.enums.ApplicationException.INVALID_REQUEST_ARGUMENT;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Exception handler to convert exception in JSON format response.
 *
 * @author Volodymyr Lykhvar
 */
@RestControllerAdvice(basePackages = "com.geometry.api.controller")
public class ApplicationExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ServiceResponseBody> handleJsonProcessingException(JsonProcessingException e) {
        LOG.warn("Json processing exception, message='{}'", e.getMessage());
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(new ServiceResponseBody(JSON_PROCESSING.getText(), JSON_PROCESSING.getCode()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceResponseBody> handleRuntimeException(RuntimeException e) {
        LOG.error("Runtime exception, message='{}'.", e.getMessage(), e);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(new ServiceResponseBody(e.getMessage(), INTERNAL_ERROR.getCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServiceResponseBody> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        LOG.warn("Method argument type mismatch, message='{}'", e.getMessage());
        var result = e.getBindingResult();
        var fieldErrors = result.getFieldErrors();
        var serviceResponseBody = new ServiceResponseBody(
                INVALID_REQUEST_ARGUMENT.getText(), INVALID_REQUEST_ARGUMENT.getCode());
        for (var fieldError: fieldErrors) {
            serviceResponseBody.getData().put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(BAD_REQUEST).body(serviceResponseBody);
    }
}
