package com.openwebinars.rest.service;

import com.openwebinars.rest.controller.FileController;
import com.openwebinars.rest.dto.CreateProductDTO;
import com.openwebinars.rest.model.Product;
import com.openwebinars.rest.repository.IProductRepository;
import com.openwebinars.rest.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.openwebinars.rest.upload.StorageService;

import lombok.RequiredArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService extends BaseService<Product, Long, IProductRepository> {

    private final CategoryService categoriaServicio;
    private final StorageService storageService;


    public Product nuevoProducto(CreateProductDTO nuevo, MultipartFile file) {
        String urlImagen = null;

        if (!file.isEmpty()) {
            String imagen = storageService.store(file);
            urlImagen = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "serveFile", imagen, null)
                    .build().toUriString();
        }


        // En ocasiones, no necesitamos el uso de ModelMapper si la conversión que vamos a hacer
        // es muy sencilla. Con el uso de @Builder sobre la clase en cuestión, podemos realizar
        // una transformación rápida como esta.

        Product nuevoProducto = Product.builder()
                .name(nuevo.getName())
                .price(nuevo.getPrice())
                .image(urlImagen)
                .category(categoriaServicio.findByIdService(nuevo.getCategoryId()).orElse(null))
                .build();

        return this.save(nuevoProducto);
    }

    public Page<Product> findByName(String texto, Pageable pageable){
        return this.repositorio.findByNameContainsIgnoreCase(texto, pageable);
    }

    public Page<Product> findByArgs(final Optional<String> name, final Optional<Float> price, Pageable pageable){
        Specification<Product> specNameProduct = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (name.isPresent()){
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%" + name.get() + "%" );
                }else{
                    return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
                }
            }
        };
        Specification<Product> precioMenorQue = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (price.isPresent()) {
                    return criteriaBuilder.lessThanOrEqualTo(root.get("price"), price.get());
                } else {
                    return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
                }
            }
        };

        Specification<Product> ambas = specNameProduct.and(precioMenorQue);

        return this.repositorio.findAll(ambas, pageable);
    }

}

