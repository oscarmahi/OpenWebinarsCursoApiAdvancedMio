package com.openwebinars.rest.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private long id;
    private String name;
    private String image;
    private String categoryName;
}
