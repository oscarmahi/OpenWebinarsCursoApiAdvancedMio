package com.openwebinars.rest.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditProductDto {

    private String name;
    private float price;

}
