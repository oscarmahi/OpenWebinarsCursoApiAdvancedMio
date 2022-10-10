package com.openwebinars.rest.dto.converter;

import com.openwebinars.rest.dto.ProductDTO;
import com.openwebinars.rest.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDTOConverter {

    private final ModelMapper modelMapper;

    public ProductDTO convertToDto(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

    /**
     * Esto es para cuando se usa la anotación @Build de lombok
     * @param product
     * @return
     */
    public ProductDTO convertProductToProductDto(Product product){
        return ProductDTO.builder()
                .name(product.getName())
                .image(product.getImage())
                .categoryName(product.getCategory().getName())
                .id(product.getId())
                .build();
    }


}
