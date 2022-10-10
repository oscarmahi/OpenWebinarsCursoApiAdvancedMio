package com.openwebinars.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id){
        super("No se puede encontar el producto con la ID: " + id);
    }



}
