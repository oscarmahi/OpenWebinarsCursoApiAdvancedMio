package com.openwebinars.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateProductDTO {

    private String name;
    private float price;
    private long categoryId;

}
