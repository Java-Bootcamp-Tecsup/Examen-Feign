package com.codigo.examenSunat.exception;

import com.codigo.examenSunat.dto.ProviderErrorResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ECEPTION RUC
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProviderErrorResponse> handleIlegalArgument(IllegalArgumentException ex){

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ProviderErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ProviderErrorResponse> handleFeignException(
            FeignException ex){
        String body = ex.contentUTF8();

        body = body.replace("[", "")
                .replace("]", "")
                .replace("{", "")
                .replace("}", "")
                .replace("\"message\":\"", "")
                .replace("\"", "");
        return ResponseEntity
                .status(ex.status())
                .body(new ProviderErrorResponse(body));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProviderErrorResponse> handleNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ProviderErrorResponse(ex.getMessage()));
    }
}
