package com.openwebinars.rest.error;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class, SearchProductNotFoundException.class})
    public ResponseEntity<ApiError> handleProductNotFound(ProductNotFoundException ex){
//        Esta es una forma de hacerlo
//      ApiError apiError = new ApiError();
//		apiError.setEstado(HttpStatus.NOT_FOUND);
//		apiError.setFecha(LocalDateTime.now());
//		apiError.setMensaje(ex.getMessage());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);

//        Esta es otra
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(status, ex.getMessage());
        return ResponseEntity.status(status).headers(headers).body(apiError);
    }

    //    @ExceptionHandler(JsonMappingException.class)
//    public ResponseEntity<ApiError> handleJsonMappingException(JsonMappingException ex){
////        ApiError apiError = new ApiError();
////        apiError.setEstado(HttpStatus.BAD_REQUEST);
////        apiError.setFecha(LocalDateTime.now());
////        apiError.setMensaje(ex.getMessage());
//        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
//    }

}
